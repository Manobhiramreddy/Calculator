pipeline {
    agent any

    tools {
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                bat '''
                    mkdir -p build
                    javac -d build Calculator.java
                '''
            }
        }

        stage('Package') {
            steps {
                bat '''
                    mkdir -p dist
                    echo "Main-Class: Calculator" > manifest.txt
                    jar cfm dist/calculator.jar manifest.txt -C build .
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
        cleanup {
            cleanWs()
        }
    }
}
