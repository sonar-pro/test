pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                // TODO 这里需要等等使用Pipeline构建器生成 记得删除此行 
	            checkout scmGit(branches: [[name: '*/master']], browser: gitLab(repoUrl: 'https://gitlab.com/sonar-users/test.git', version: '15.6'), extensions: [], userRemoteConfigs: [[credentialsId: '7e24d4d2-cd57-4620-8517-a9d141bd16a5', url: 'https://gitlab.com/sonar-users/test.git']])
            }
        }
        stage('build project') {
            steps {
                sh label: '', script: 'mvn clean install package -Dmaven.test.skip=true'
            }
        }
        stage('code checking') {
            steps {
                script {
                    //引入SonarqubeScanner工具
                    //sonarqube-scanner为在jenkins中定义的工具名称
                    scannerHome = tool 'SonarScanner'
                }
	            //引入SonarQube服务器环境，MySonarQube为我们为环境起的名称
                withSonarQubeEnv('Sonarqube') {
		            //sonarqube-scanner工具下的脚本
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
    }
}