# Use uma base image do WebSphere Application Server 8.5.5
FROM websphere-liberty:8.5.5

# Copie arquivos de configuração necessários
COPY server.xml /config/

# Copie o arquivo WAR do serviço marketplace-service
#COPY marketplace-service/target/marketplace-service.war /config/dropins/marketplace-service.war

# Copie o arquivo WAR do serviço marketplace-checkout
#COPY marketplace-checkout/target/marketplace-checkout.war /config/dropins/marketplace-checkout.war

# Copie o arquivo WAR do serviço marketplace-processamento
#COPY marketplace-processamento/target/marketplace-processamento.war /config/dropins/marketplace-processamento.war

# Copie o arquivo WAR do serviço marketplace-notificacao
#COPY marketplace-notificacao/target/marketplace-notificacao.war /config/dropins/marketplace-notificacao.war

# Defina variáveis de ambiente se necessário
ENV LICENSE accept
ENV JVM_ARGS="-Xms256m -Xmx1024m"

# Exponha as portas necessárias
EXPOSE 9080 9443

# Comando para iniciar o servidor WebSphere
CMD ["/opt/ibm/wlp/bin/server", "run", "defaultServer"]
