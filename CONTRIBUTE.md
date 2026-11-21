 # CONTRIBUTING til Smart Project Planner

Tak fordi du vil bidrage til Smart Project Planner! Her kan du læse, hvordan du kommer i gang med udviklingen.

## Kom godt i gang

1. Bed en owner om adgang til GitHub-organisationen **Merge-Queen-org**.
2. Klon projektet fra GitHub.
3. Åbn projektet i IntelliJ.
4. Skift til branchen `develop`.
5. Kør `schema.sql` og derefter `data.sql` i MySQL Workbench.
6. Start applikationen. Den kører med `dev`-profilen og din lokale MySQL-database.
7. Åbn http://localhost:8080 i din browser.

## Profiler

* `dev`: lokal MySQL-database til udvikling
* `prod`: MySQL-database i Azure (den deployede applikation)
* `test`: H2-database til tests

## Projektstruktur

Projektet er opdelt i følgende mapper:

* **controller**: håndterer requests fra brugeren
* **service**: indeholder applikationens logik og beregninger, fx samlet tidsforbrug og timer pr. dag
* **repository**: håndterer databasen med JdbcTemplate
* **model**: indeholder klasserne Project, Subproject, Task, Subtask, Employee og Office
* **templates**: indeholder HTML-sider (Thymeleaf)
* **static**: indeholder CSS-filer
* **resources**: indeholder `application.properties` og mappen `sql` med SQL-scripts

Controllere kalder kun services, og services kalder kun repositories.

## Udviklingsproces

Vi arbejder med Scrum og bruger **GitHub Projects** som board.

### Når du arbejder på en ny user story

1. Tag en opgave fra **ToDo** på boardet, og sæt dig selv som **assignee**.
2. Flyt opgaven til **In progress**.
3. Hent de nyeste ændringer fra `develop`.
4. Opret en ny branch ud fra `develop`.
5. Lav dine ændringer, og test dem.
6. Commit og push din kode.
7. Opret en Pull Request til `develop`, og flyt opgaven til **In review**.
8. Få et andet gruppemedlem til at gennemgå og godkende ændringerne.
9. Når Pull Requesten er merget, flyttes opgaven til **Done**.

## Branches

* `main`: færdig og testet kode, som deployes til Azure
* `develop`: samler godkendte ændringer og er udgangspunkt for nye branches
* `feature-branch/US<nr>-navn`: nye funktioner, fx `feature-branch/US1-opret-projekt`
* `fix/<US-nr>-navn`: rettelse af fejl

Ved slutningen af hvert sprint merges `develop` ind i `main`.

## Pull Requests

* Push aldrig direkte til `main` eller `develop`.
* En Pull Request skal godkendes af mindst **1 andet gruppemedlem**.
* Alle tests skal være grønne i GitHub Actions, før der merges.
* Kode, der ikke kører, merges ikke.

## Commit-beskeder

Skriv korte commit-beskeder:

* `feat: tilføj opret projekt`
* `fix: ret beregning af timer`
* `test: test controller`

Commit ofte, og push mindst én gang om dagen.

## Coding Standards

* Skriv tydelig og læsbar kode.
* Brug beskrivende navne til klasser, metoder og variabler.
* Følg projektets eksisterende struktur.
* Brug egne exceptions i stedet for tomme catch-blokke.
* Upload aldrig passwords eller andre følsomme oplysninger til GitHub.

## Test

* Test service-klasser med JUnit og Mockito.
* Test controllere med MockMvc.
* Kør alle tests og start applikationen, før du laver en Pull Request.

## Spørgsmål

* Sidder du fast i mere end 30 minutter, så skriv på Teams.
* Kontakt projektets contributors ved spørgsmål.
