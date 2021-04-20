# songr

It's a simple full-stack web app using Spring Boot.

### ___________________

## to run the App:

* ***You need to create and configure a postgres DB named albums => check the `application.properties` file***
* clone the repo. 
* open it using IDE
* run the `SongrApplication` class
* open your browser
* go to `http://localhost:8080`


you will see the home page of Songr app..

You can go to other pages directly like:
* `http://localhost:8080/hello` => to print hello world
* `http://localhost:8080/capitalize/`*your text here* => to capitalize your text and display it on the browser.
* `http://localhost:8080/albums` => to show the all albums and their details.
* `http://localhost:8080/albums/``albumID` => to show the details of a specific Album
* `http://localhost:8080/addAlbum` => to add new album
* `http://localhost:8080/addSong` => to add new Song
* `http://localhost:8080/Songs` => to show the all songs



### OR from CLI:

* Go to the root directory
* Run the following command `./gradlew bootRun`

### ___________________

## to test the App:

* either from the IDE.. run the `AlbumTest` calss tests.
* or from the terminal .. run the following command: `./gradlew test` (in the root directory)

### ___________________