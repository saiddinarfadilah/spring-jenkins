pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'steps build 1'
                echo 'steps build 2'
                echo 'steps build 3'
                sleep(5)
	            bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'steps test 1'
                echo 'steps test 2'
                sleep(5)
                echo 'steps test 3'
            }
        }
        stage('Deploy') {
            steps {
                echo 'steps deploy 1'
                echo 'steps deploy 2'
                sleep(5)
                echo 'steps deploy 3'
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
