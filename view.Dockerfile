FROM node:10.18.1-jessie-slim

RUN mkdir /c && npm install -g @angular/cli

WORKDIR /c

EXPOSE 4200

USER node

RUN mkdir /home/node/.npm-global
ENV PATH=/home/node/.npm-global/bin:$PATH
ENV NPM_CONFIG_PREFIX=/home/node/.npm-global

CMD ["ng", "serve", "--host", "0.0.0.0"]