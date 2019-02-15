pipeline {
    agent any

    stages {

//        stage('SonarQube analysis') {
//            steps {
//                script {
//                    withSonarQubeEnv('SonarQube Server') {
//                        sh './gradlew sonarqube -Dsonar.host.url=http://sonarqube:9000'
//                    }
//
//                    timeout(time: 1, unit: 'HOURS') {
//                        def qg = waitForQualityGate()
//                        if (qg.status != 'OK') {
//                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
//                        }
//                    }
//                }
//            }
//        }

        stage('Run Emulator') {
            steps {
                sh 'adb connect emulator'
            }
        }

        stage('Lint') {
            steps {
                script {
                    try {
                        sh './gradlew lint'
                    } catch (err) {
                        androidLint()
                        currentBuild.result = 'FAILURE'
                        error('Lint found issues...')
                        throw err
                    }
                }
            }
        }

        stage('Unit Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Android Test') {
            steps {
                sh './gradlew connectedAndroidTest'
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
                    currentBuild.description = "<a href=\"http://localhost:9000/projects?sort=-analysis_date\">SonarQube</a>"
                }
            }
        }
    }
}