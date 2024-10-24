@Library('jenkins-shared-library') _
pipeline {
    agent any

    stages {
        stage('Start') {
            steps {
                script {
                    samplePipeline()
                }
            }
        }
    }
}
