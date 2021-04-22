# cookiecutter-kotlin-typescript

![main workflow status](https://github.com/reside-ic/cookiecutter-kotlin-typescript/actions/workflows/main.yml/badge.svg)

## Contents

- Kotlin, Spring Boot, Fuel, Logstash Logback Encoder
    - Detekt, JUnit, mockito-kotlin, JaCoCo
- Vue 3, Vuex, Vue Router, Axios, BootstrapVue
    - TypeScript, Babel, ESLint, Jest, Node-sass (via Vue CLI)
- Docker and Buildkite configuration

## Instructions

To create a new project run the following (no need to clone this repo first):

```shell
pip install cookiecutter
cookiecutter gh:reside-ic/cookiecutter-kotlin-typescript
```

Then:

- Move the new folder somewhere and push it to GitHub
- Add a licence
- Make Codecov token accessible to Buildkite agents
