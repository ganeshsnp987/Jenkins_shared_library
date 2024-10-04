def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=6de1f6faf6msh617aef29eaa8cfdp107c21jsnc74e1b2feb27 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker-cred']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
