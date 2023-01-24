<h3>Project grade: 17,3/20</h3>
<h3>Remember that copying this project to make yours, might get you caught by a coyright test.</h3>

## LDTS_0602 - Minesweeper

<h3> Warning! </h3> 
This is only the simplified version of README.md file, the complete version is in the docs directory.

<h1>Minesweeper </h1>
  Minesweeper is single-player logic-based computer game played on a rectangular board whose object is to locate a predetermined
number of randomly-placed bombs in the shortest possible time by clicking on the safe cells, while avoiding the cells with bombs.
If the player clicks on a bomb, the player loses and the game ends. On the other hand, if the player clicks a cell 
containing a number between one and eight, or an empty cell, the cell is displayed, and that identifies the total number of bombs
that are present in the eight neighboring cells. Therefore, finding a cell containing the number eight indicates that
all eight adjacent cells contain bombs, while if an empty cell is uncovered, it means that there are no bombs in the surrounding cells. 
A cell suspected of containing a mine may be marked with a flag. In this implementation of Minesweeper we tried to make it as
similar as possible to the original one. The only difference between ours and the one created by Microsoft is that we replaced the use
of the mouse with a cursor. The cursor is controlled through the use of the keyboard keys "ASWD" or the arrow keys to 
move across the board, "ENTER" to select a cell, "Q" to return to the main menu and "F" to place or remove a flag during a game.

<h3>How to start playing</h3>

At the start menu, you have the option to choose the difficulty level, associated to a board size. The difficulty level will
also determine how many bombs you have to avoid/find in your playthrough. Easy difficulty will generate a 10x10 board with 10 bombs,
medium difficulty will generate a 16x16 board with 40 bombs, and hard difficulty will generate a 30x16 board with 99 bombs.

<h3>How to play the game</h3>

Once you are presented with your board, you can click any cell to start. This will reveal the content of the cell,
which is frequently a number. This number indicates how many bombs there are adjacent to that cell, in any of the 8
adjacent cells (horizontally, vertically and diagonally).
To aid you in avoiding mines, you can flag cells where you think there might be a mine by pressing the "F" key.

<h3> Credits </h3>
This game was developed by: João Ribeiro (up201305891@fe.up.pt), Pedro Valente (up201904865@fc.up.pt), João Alves (up202108670@fe.up.pt), 
for the LDTS 2022/2023 course.

# Resources

Our GUI is created/displayed using the Lanterna API, by Google:<br>
http://mabe02.github.io/lanterna/apidocs/3.0/overview-summary.html <br>

For our testing, we use the Mockito library to aid in the construction of mocks and stubs:<br>
https://site.mockito.org/ <br>

For some property-based testing we will use Jqwik library<br>
https://jqwik.net/ <br>

# List of implemented features

<h3>Flag cells</h3>
We implemented a feature that allows players to press "F" when the pointer is in a clickable-cell in order to flag it,
meaning that it might have a mine in it. If a player presses "F" again in a cell that is already flagged, the flag will
be removed and a clickable-cell will appear once again.

<h3>Empty cell expansion (cluster of empty cells)</h3>
Whenever a clickable-cell is clicked, i.e, not numbered and bomb-free, we implemented an "expansion", so that all
adjacent cells are revealed until a numbered cell is found. This is done in a cascade/recursive form, also
expanding newly revealed empty cells. To implement that expansion a floodfill algorithm was used.

<h3>Simple timer</h3>
Having a time counter that shows us the time that we are taking to complete a new game is displayed during the game. The time that
took us to complete it, or to lose it, is shown in the final menu.

<h3>Three difficulties</h3>
We implemented three difficulties to the game, easy, medium, and hard, as the original version of Microsoft
Minesweeper. Easy difficulty generates a 10x10 board of cells with 10 mines, medium difficulty generates a
16x16 map with 40 mines, and hard difficulty generates a 30x16 map with 99 mines.

<h3>Randomly generated games</h3>
When we select a difficulty in the menu, all the cells will be created in order to create the board. The bomb cells will
be generated randomly, so the players will be playing a different game each time they play again. With that, the numbers will
also be generated differently each time a new game is played because the bombs will be in different positions each game.

<h3>Bombs left counter</h3>
We implemented a counter that counts how many bombs are left in the board without a flag on top. This works based on the
number of bombs that exist in that difficulty minus the number of flags placed in the board. At the end of the game, in case
of a loss, we display the number of bombs still left to be found that were not flagged during the game.

<h3>Simple menus</h3>
In order to make the users' life simpler, we implemented various Menus such as: the main menu, the difficulty menu and
the win and loss menus.

# Mockups

![Mockup1](https://user-images.githubusercontent.com/92686905/209131084-3c30c3a1-42c8-4d09-bed4-90faa2c25837.png)
![Mockup2](https://user-images.githubusercontent.com/92686905/209131086-30441f1f-3cbd-4385-9da0-a66bdc9882e0.png)
![Mockup3](https://user-images.githubusercontent.com/92686905/209131087-a87f5328-aecb-429c-b13c-c671f3ea860a.png)
![Mockup4](https://user-images.githubusercontent.com/92686905/209131089-cf1fb305-fe31-4f8e-b9be-29f482e7c7fd.png)

# Game demo
![AGameDemo](https://user-images.githubusercontent.com/92686905/209138723-d9fd50a1-e087-4395-9f9a-43bbe6d2136a.gif)
<h4>Link to the youtube vídeo with the demo</h4>
https://www.youtube.com/watch?v=U5Xgy976OQU&ab_channel=Jo%C3%A3oAlves
