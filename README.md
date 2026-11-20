# SmartProjectPlanner – Projektkalkulationsværktøj

*2. semester eksamensprojekt, datamatiker F26*

## Om projektet

Smart Project Planner er en webapplikation til Alpha Solutions, hvor projektledere kan planlægge projekter og beregne tidsforbrug.

Man kan nedbryde et projekt i delprojekter, opgaver og delopgaver. Hver opgave kan have estimerede timer, en startdato og en deadline. Systemet beregner det samlede tidsforbrug, og hvor mange timer der skal arbejdes pr. dag for at kunne nå deadline.

## Kørende applikation

[Link til applikationen i Azure](INDSÆT-LINK)

## Gruppemedlemmer

Nadira\
Kwan\
Jenny\
Celine

## Teknologier

Java 25\
Spring Boot\
Thymeleaf\
MySQL\
H2\
HTML & CSS\
Maven\
JUnit & Mockito\
IntelliJ IDEA 2025\
GitHub Actions og GitHub Projects\
Azure (App Service og MySQL)

## Funktioner

Vis, opret, rediger og slet projekter\
Vis, opret, rediger og slet delprojekter, opgaver og delopgaver\
Angiv estimerede timer og start- og slutdatoer\
Beregn samlet tidsforbrug\
Beregn dagligt timebehov for at nå deadline\
Oversigt over alle projekter

## Sådan starter du applikationen

1. Klon projektet fra GitHub.
2. Åbn projektet i IntelliJ.
3. Kør applikationen. Den starter med `dev`-profilen og en H2-database.
4. Åbn http://localhost:8080 i din browser.

## Profiler

`dev` (development): H2-database til lokal udvikling og test\
`prod` (produktion): MySQL-database i Azure

## Database

SQL-scripts til oprettelse af databasen og testdata ligger i `src/main/resources`.

## Projektstyring

User stories, sprints og tasks findes i GitHub Projects: [Link til GitHub Projects](INDSÆT-LINK)

## Databasedesign

[ER-diagram i Lucid](INDSÆT-LINK)

## Klassediagram

[Klassediagram](INDSÆT-LINK)

## Contributing

Læs [CONTRIBUTE.md](CONTRIBUTE.md), hvis du vil vide, hvordan du kan bidrage til projektet.
