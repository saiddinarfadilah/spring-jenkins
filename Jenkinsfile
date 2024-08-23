pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials' // ID kredensial yang telah disimpan
    }
    stages {
        stage('Login to Docker Hub') {
            steps {
                script {
                    // Login ke Docker Hub menggunakan kredensial
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        echo "Logged in to Docker Hub"
                    }
                }
            }
        }
        stage('Build and Test') {
            steps {
                script {
                    // Menjalankan container menggunakan image dari Docker Hub
                    docker.image('maven:3.9.9-eclipse-temurin-21-alpine').inside {
                        // Menjalankan perintah di dalam container
                        sh 'mvn --version'
                    }
                }
            }
        }
    }
}
