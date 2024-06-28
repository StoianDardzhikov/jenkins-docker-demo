pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'myapp'  // Name of the Docker image
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/StoianDardzhikov/jenkins-docker-demo.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'  // Build the Maven project and create the JAR file
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image with a unique tag using the BUILD_ID
                    docker.build("${env.DOCKER_IMAGE}:${env.BUILD_ID}")
                }
            }
        }

        stage('Deploy Docker Container') {
            steps {
                script {
                    // Stop and remove any existing container named spring-boot-app
                    sh 'docker stop myapp || true'
                    sh 'docker rm myapp || true'

                    // Run the new Docker container, mapping port 8080 of the container to port 8081 on the host
                    docker.image("${env.DOCKER_IMAGE}:${env.BUILD_ID}").run('-p 8081:8080 --name myapp')
                }
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean up the workspace after the build
        }
    }
}