pipeline {
    agent any

    stages {

        stage('findbugs') {
            steps {
                sh './gradlew findbugs'
                publishHTML target: [
                        allowMissing: true,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'app/build/reports/findbugs',
                        reportFiles: 'findbugs-output.html',
                        reportName: 'FindBugs Report'
                ]
            }
        }

        stage('checkstyle') {
            steps {
                sh './gradlew checkstyle'
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

        stage('Lint') {
            steps {
                script {
                    try {
                        sh './gradlew lintCi'
                        androidLint()
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        error('Lint error...')
                        throw err
                    }
                }
            }
        }

        stage('Unit Test') {
            steps {
                sh './gradlew testCiUnitTest'
            }
        }

        stage('Run Emulator') {
            steps {
                sh 'adb connect jenkins'
            }
        }

        stage('Android Test') {
            steps {
                sh 'cd server && ./run.sh &'
                sh 'cd ..'
                sh './gradlew connectedCiAndroidTest'
                sh 'kill $(lsof -t -i:5000)'
            }
        }

        stage('SonarQube analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube Server') {
                        sh './gradlew sonarqube -Dsonar.host.url=http://jenkins:9000'
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