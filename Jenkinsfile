pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Compile') {
            steps {
                bat '''
                    if not exist build mkdir build
                    javac -d build Calculator.java
                '''
            }
        }
        stage('Package') {
            steps {
                bat '''
                    if not exist dist mkdir dist
                    echo Main-Class: Calculator > manifest.txt
                    jar cfm dist\\calculator.jar manifest.txt -C build .
                '''
            }
        }
        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'dist/calculator.jar', fingerprint: true
            }
        }
    }
    post {
        success {
            echo "Build complete. Packaged JAR available as artifact."
        }
        failure {
            echo "Build Failed."
        }
    }
}
