@Library('jenkins-shared-library') _
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    sampleLibrary3.buildProject('maven')
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sampleLibrary3.runTests('maven')
                }
            }
        }
    }

    post {
        success {
            script {
                sampleLibrary3.notify('success','#devops-channel')
            }
        }
        failure {
            script {
                sampleLibrary3.notify('failure','#devops-channel')
            }
        }
    }
}
