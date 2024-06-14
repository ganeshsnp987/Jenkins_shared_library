def call() {
    sh 'trivy image ganeshsnp987/youtube:latest > trivyimage.txt'
}