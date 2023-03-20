# Gatling

## pre-requisites

- git
- docker

## Steps
### Step 1: Cloning repository

```shell
cd ~
git clone git@github.com:blanselle/gatling.git
```

### Step 2: Edit scenario

Replace XXX values in SimulationsTest.scala

### Step 3: run gatling
```shell
docker run -it --rm -v /home/blanselle/Projects/Exotec/gatling/conf:/opt/gatling/conf -v /home/blanselle/Projects/Exotec/gatling/user-files:/opt/gatling/user-files -v /home/blanselle/Projects/Exotec/gatling/results:/opt/gatling/results denvazh/gatling
```

### Step 4: Analyze report

Open idex.html file in new folder of results folder