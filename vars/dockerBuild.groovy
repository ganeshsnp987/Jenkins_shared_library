def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=b9a7636625msh9bcce9072a4f620p110088jsndcdee6a8d510 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker-cred']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}