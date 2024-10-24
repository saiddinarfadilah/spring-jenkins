@Library('jenkins-shared-library') _
pipeline {
    agent any

    options {
        timeout(time: 20, unit: 'MINUTES')
    }

    stages {
        stage('BUILD') {
            when {
                branch 'sit'
            }
            steps {
                script {
                    sampleLibrary.sayHello('said')
                }
            }
        }

        stage('TEST') {
            steps {
                echo "test done"
            }
        }

        stage('DEPLOY') {
            steps {
                echo "deploy done"
            }
        }
    }

    post {
        success {
            echo 'process, success'
        }
        failure {
            echo 'Oh no, process failure'
        }
        cleanup {
            cleanWs()
        }
    }
}