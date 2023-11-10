# ALPOO

## Introduction

This project was created as the final project for the 4th semester of the Computer Science Bachelor's program. The main focus of this project was SQL (using MySQL) and the application of OOP (Object-oriented programming).

This repository uses the following design patterns:
  * MVC (Model View Controller)
  * Singleton
  * DAO (Data access object)
  * DTO (Data transfer object)

## Setup

### Environments
  * This project utilizes local environments to set up the database and connections.
  * To create the local setup, add a `/.env` file at the root and include all the required environment variables (a list of required variables is described in `/.env.public`).

### Database
  * It uses Docker to set up the local database, so you'll need to install Docker before continuing.
  * To start the database container, use `docker-compose up -d`.
  * After running this project, if you want to remove the container, use `docker-compose down`.
  * All files created for this database will be in the `/data` directory, which will be used for future database recreations.

### Running the project
  * Make sure to have Maven installed.
  * To run this project, simply use `mvn compile exec:java`.

## Contributions

As a graduation project, I am aware that some aspects of this code may not be perfect. Therefore, anyone who is interested is welcome to help and contribute.
