pipeline {
    agent any

    environment {
        FLAVOR = 'Prod'//Prod,Mock
    }

    stages {
        stage('init') {
            steps {
                sh './gradlew --stop && ./gradlew clean'
            }
        }

        stage('pmd') {
            steps {
                script {
                    try {
                        sh './gradlew pmd'
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        error('pmd error...')
                        throw err
                    } finally {
                        publishHTML target: [
                                allowMissing: false,
                                alwaysLinkToLastBuild: false,
                                keepAll: true,
                                reportDir: 'app/build/reports/pmd',
                                reportFiles: 'pmd.html',
                                reportName: 'PMD Report'
                        ]
                    }
                }
            }
        }

        stage('findbugs') {
            steps {
                script {
                    try {
                        sh './gradlew findbugs'
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        error('findbugs error...')
                        throw err
                    } finally {
                        publishHTML target: [
                                allowMissing: false,
                                alwaysLinkToLastBuild: false,
                                keepAll: true,
                                reportDir: 'app/build/reports/findbugs',
                                reportFiles: 'findbugs-output.html',
                                reportName: 'FindBugs Report'
                        ]
                    }
                }
            }
        }

        stage('checkstyle') {
            steps {
                script {
                    try {
                        sh './gradlew checkstyle'
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        error('lint error...')
                        throw err
                    } finally {
                        publishHTML target: [
                                allowMissing: false,
                                alwaysLinkToLastBuild: false,
                                keepAll: true,
                                reportDir: 'app/build/reports/checkstyle',
                                reportFiles: 'checkstyle.html',
                                reportName: 'Checkstyle Report'
                        ]
                    }
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    try {
                        sh "./gradlew lint${FLAVOR}Ci"
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        error('lint error...')
                        throw err
                    } finally {
                        androidLint()
                    }
                }
            }
        }

        stage('Unit Test') {
            steps {
                sh "./gradlew test${FLAVOR}CiUnitTest"
            }
        }

        stage('Android Test') {
            steps {
                retry(3) {
                    sh 'adb kill-server'
                    sh 'adb connect jenkins'
                    sh 'cd server && env ENV=ci ./run.sh &'
                    sh "./gradlew connected${FLAVOR}CiAndroidTest -PENV=ci"
                    sh 'kill $(lsof -t -i:5000)'
                    sh 'adb disconnect jenkins'
                }
            }
        }

        stage('SonarQube analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube Server') {
                        retry(3) {
                            sh './gradlew sonarqube -Dsonar.host.url=http://jenkins:9000'
                        }
                    }

                    timeout(time: 5, unit: 'MINUTES') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                    currentBuild.description = "<a href=\"http://localhost:9000/projects?sort=-analysis_date\">SonarQube</a>"
                }
            }
        }

        stage('PackageAPKs') {
            steps {
                sh './gradlew assemble'
            }
        }

        stage('Deploy') {
            steps {
                archiveArtifacts artifacts: '**/*.apk', excludes: '**/*-unsigned.apk'
                script {
                    currentBuild.displayName = "第${BUILD_NUMBER}次构建"
                }
            }
        }
    }
}