pipeline {
    agent any

    environment {
        SECRET = credentials('ID_SECRET')
    }

    parameters {
        string(name: 'PROJECT_NAME', defaultValue: '', description: 'Project Name')
        booleanParam(name: 'IS_PRODUCTION', defaultValue: false, description: 'Is Production')
        choice(name: 'TYPE', choices: ['clean', 'package', 'install'], description: 'Type')
        password(name: 'PASSWORD', defaultValue: '', description: 'Password')
    }

    stages {
        stage('Build') {
            steps {
                echo "steps build with ID_SECRET : ${SECRET}"
                echo "project : ${params.PROJECT_NAME} , production : ${params.IS_PRODUCTION}"
                echo "execute job ${JOB_NAME} : ${BUILD_NUMBER}"
	            bat "mvn ${params.choice}"
                sleep(5)
	            echo "build done by ${SDF_AUTHOR}"
            }
        }
        stage('Test') {
            steps {
                echo "steps test with ID_SECRET : ${SECRET}"
                sleep(5)
                echo "test done by ${SDF_AUTHOR}"
            }
        }
        stage('Deploy') {
            steps {
                echo "steps deploy with ID_SECRET : ${SECRET}"
                sleep(5)
                echo "deploy done by ${SDF_AUTHOR}"
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
