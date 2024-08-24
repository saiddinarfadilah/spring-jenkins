pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'steps build'
            }
        }
        stage('Test') {
            steps {
                echo 'steps test'
                bat 'error' // error
            }
        }
        stage('Deploy') {
            steps {
                echo 'steps deploy'
            }
        }
    }
    
    post {
	    always {
		    echo 'I will always say Hello again!'
	    }
	    success {
		    echo 'Yay, success'
	    }
	    failure {
		    echo 'Oh no, failure'
	    }
	    cleanup {
		    echo "Don't care success or failure"
	    }
    }
}
