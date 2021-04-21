package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

    @Autowired
    private MockMvc mockMvc ;

    @Autowired
    AlbumController albumController;

    @Test
    public void testControllerNotNull(){
        assertThat(albumController).isNotNull();
    }

    @Test
    public void testAlbumsPage() throws Exception {
        String expected ="<h2>Albums:</h2>\n" +
                "<div>\n" +
                "    <p>ID: <span>2</span></p>\n" +
                "    <p>Title: <span>second album</span></p>\n" +
                "    <p>Artist: <span>tamer</span></p>\n" +
                "    <p>Song Count: <span>8</span></p>\n" ;
        mockMvc.perform(get("/albums")).andDo(print()).andExpect(content().string(containsString(expected)));
    }
    @Test
    public void testSpecificAlbumPage() throws Exception {
        String expected="<h2>Albums:</h2>\n" +
                "<div>\n" +
                "    <p>ID: <span>1</span></p>\n" +
                "    <p>Title: <span>first Album</span></p>\n" +
                "    <p>Artist: <span>Wael</span></p>\n" +
                "    <p>Song Count: <span>8</span></p>\n" +
                "    <p>Length: <span>2100</span></p>\n" +
                "    <a href=https://link/to/imageUrl>Image url</a>\n" +
                "    <p>Songs: </p>\n" +
                "    <ul style=\"display:inline-block\">\n" +
                "        <li>Song ID: <span>1</span></li>\n" +
                "        <li>Song Title: <span>hello</span></li>\n" +
                "        <li>Song Length: <span>220</span></li>\n" +
                "        <li>Track Number: <span>1</span></li>\n" +
                "    </ul>";
        mockMvc.perform(get("/albums/1")).andDo(print()).andExpect(content().string(containsString(expected)));
    }
    @Test
    public void testAddAlbumPage() throws Exception {
        String expected="<h2>Add A New Album</h2>\n" +
                "<form action=\"/addAlbum\" method=\"POST\">\n" +
                "    <label for=\"title\">Title:  <input type=\"text\" name=\"title\" id=\"title\"> </label><br>\n" +
                "    <label for=\"artist\">Artist:  <input type=\"text\" name=\"artist\" id=\"artist\"> </label><br>\n" +
                "    <label for=\"imageUrl\">Image URL: <input type=\"text\" name=\"imageUrl\" id=\"imageUrl\"> </label><br>\n" +
                "    <input type=\"submit\" value=\"Add Album\">\n" +
                "</form>";
        mockMvc.perform(get("/addAlbum")).andDo(print()).andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testAddSongPage() throws Exception {
        String expected="<h2>Add A New Song</h2>\n" +
                "<form action=\"/addSong\" method=\"POST\">\n" +
                "    <label for=\"title\">Title:  <input type=\"text\" name=\"title\" id=\"title\"> </label><br>\n" +
                "    <label for=\"length\">Length (in seconds):  <input type=\"number\" name=\"length\" id=\"length\"> </label><br>\n" +
                "<!--    <label for=\"trackNumber\">track Number:  <input type=\"number\" name=\"trackNumber\" id=\"trackNumber\"> </label><br>-->\n" +
                "    <label for=\"albumId\">album Id: <input type=\"number\" name=\"albumId\" id=\"albumId\"> </label><br>\n" +
                "    <input type=\"submit\" value=\"Add Album\">\n" +
                "</form>";
        mockMvc.perform(get("/addSong")).andDo(print()).andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testSongsPage() throws Exception {
        String expected="<h2>All Songs:</h2>\n" +
                "<div>\n" +
                "    <p>ID: <span>1</span></p>\n" +
                "    <p>Title: <span>hello</span></p>\n" +
                "    <p>Length: <span>220</span></p>\n" +
                "    <p>Track Number: <span>1</span></p>\n" +
                "    <p>Album: </p>\n" +
                "    <ul style=\"display:inline-block\">\n" +
                "        <li>Album ID: <span>1</span></li>\n" +
                "        <li>Album Title: <span>first Album</span></li>\n" +
                "        <li>Album Artist: <span>Wael</span></li>\n" +
                "        <li>Album Song Count: <span>8</span></li>\n" +
                "        <li>Album Length: <span>2100</span></li>\n" +
                "        <li>Album Image URL: <span>https://link/to/imageUrl</span></li>\n" +
                "    </ul>\n" +
                "    <hr>\n" +
                "</div>";
        mockMvc.perform(get("/songs")).andDo(print()).andExpect(content().string(containsString(expected)));
    }


}
