<h1>LDTS_0602 - Minesweeper</h1>
  Minesweeper is single-player logic-based computer game played on a rectangular board whose object is to locate a predetermined
number of randomly-placed bombs in the shortest possible time by clicking on the safe cells, while avoiding the cells with bombs.
If the player clicks on a bomb, the player loses and the game ends. On the other hand, if the player clicks on a cell 
containing a number between one and eight, or an empty cell, the cell is displayed, and that identifies the total number of bombs
that are present in the eight neighboring cells. Therefore, finding a cell containing the number eight indicates that
all eight adjacent cells contain bombs, while if an empty cell is uncovered, it means that there are no bombs in the surrounding cells. 
A cell suspected of containing a bomb may be marked with a flag. In this implementation of Minesweeper we tried to make it as
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
To aid you in avoiding bombs, you can flag cells where you think there might be bombs by pressing the "F" key.

<h3> Credits </h3>
This game was developed by: João Ribeiro (up201305891@fe.up.pt), Pedro Valente (up201904865@fc.up.pt), João Alves (up202108670@fe.up.pt), 
for the LDTS 2022/2023 course.

# Resources

Our GUI is created/displayed using the Lanterna API, by Google:<br>
http://mabe02.github.io/lanterna/apidocs/3.0/overview-summary.html <br>

For our testing, we use the Mockito library to aid in the construction of mocks and stubs:<br>
https://site.mockito.org/ <br>

For some property-based testing have used Jqwik library<br>
https://jqwik.net/ <br>

# List of implemented features

<h3>Flag cells</h3>
We implemented a feature that allows players to press "F" when the pointer is in a clickable-cell in order to flag it,
meaning that it might have a bomb in it. If a player presses "F" again in a cell that is already flagged, the flag will
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
<h4>Link to the YouTube video with the demo</h4>
https://www.youtube.com/watch?v=U5Xgy976OQU&ab_channel=Jo%C3%A3oAlves


# Implemented patterns
<p>In order to make our work easier we decided to implement the following patterns: Factory Method Pattern, State Pattern 
and Model-View-Controller Architectural Pattern. That way, if we need to add or change something that hasn't been planned
in the beginning of the project, it will be much easier than it would be without those design patterns.<p>  

<h2>Consequences of the patterns</h2>

<h3>Factory Method Pattern</h3>
<p>Using this design pattern will lead to eliminating the need to bind specific application classes in the code.
This way we can have code with simpler bindings to other classes and that makes the understanding of the code easier.<p>  

<h3>State Pattern</h3>
<p>The consequences of using this design pattern are that it makes game state transitions more explicit and it 
localizes and partitions the behavior of different game states.<p>

<h3>Model-View-Controller Architectural Pattern</h3>
<p>Implementing this architectural pattern will make developing user interfaces way easier, by dividing the application
in three parts: Model, Controller and View. Model is used to represent the game data, View displays the Model data and
Controller provides the data from Model to View, and interprets user actions.<p>  

# Detailed implementation - UML
![UML_FINAL](https://user-images.githubusercontent.com/92686905/209398709-b3ba0032-2202-446b-bfe1-c155c30d14f5.jpg)

# Testing
<h3>Used resources</h3>
In order to make our life and the readability of the tests easier, we decided to use: JUnit, so we could automate the 
testing process; Mockito, in order to make the creation of mocks more obvious and simple; and Jqwik, to implement some
property based testing, although it was only used in the Position class. 

<h3>Test coverage</h3>
<h4>Controller</h4>

![ControllerCoverage](https://user-images.githubusercontent.com/92686905/209400722-da5e62ad-3fac-47e4-8cf7-7aace097f147.jpg)

<h4>Gui</h4>

![GuiCoverage](https://user-images.githubusercontent.com/92686905/209400731-995f9f8e-b85f-4ad8-8e1d-86a2faff31c3.jpg)

<h4>Model</h4>

![ModelCoverage](https://user-images.githubusercontent.com/92686905/209400763-3d36374f-bebe-4024-a88e-a27b7525519c.jpg)

<h4>State</h4>

![StateCoverage](https://user-images.githubusercontent.com/92686905/209400770-88f5015c-23cb-4803-bc7c-29e67ea53ab0.jpg)

<h4>Viewer</h4>

![ViewerCoverage](https://user-images.githubusercontent.com/92686905/209400774-c5d18de5-620f-40bd-997c-f0e06f592d65.jpg)

<h3>Mutation testing: Pitest</h3>

![PIT](https://user-images.githubusercontent.com/92686905/209400605-dd702d27-d87f-4ec5-a9e8-6dd9feade78b.jpg)

# Refactoring and Code Smells
After refactoring our code we noticed that it had some code smells. We solved the majority part of them, but we still have some.

<h2>Bloaters</h2>
<h3>Long Method</h3>
In order to make the cell expansion work correctly, the methods step() and floodFill() presented in the PointerController
have to be long and complex methods, so they are more prepared for all the cases that can occur during the gameplay. We wanted to use
the refactor method Composing Methods: Extract Method, and distribute the methods and responsibility  between other Controllers, 
but we didn't find a proper way to do it, so the smell is still present in the code.

<h2>Object-Orientation Abusers</h2>
<h3>Switch Statements</h3>
This particular code smell is present throughout our code, but mainly in the controllers and in the class LoaderBoardBuilder.
Some of them were solved using the refactor method Composing Methods: Extract Method, some were only simplified and others are still
in the code, as we thought it would keep the code more robust. The simplified ones were mainly converted in a simpler switch case
instead of a big amount of if-else statements. 

<h2>Dispensables</h2>
<h3>Lazy Class</h3>
In the beginning of the project we wanted to use a controller for every single type of element that we had, but upon refactoring
we noticed that some of them just didn't change or control anything in the game, such as WallController, EmptyCellController,
BombController and NumController. In addition, we noticed that the Flag and FlagController classes were completely useless, because a flag
was not really a type of object that we needed to implement in the game, as a flag is only a character that is drawn in the screen during the game.
To fix that we simply deleted those classes.

<h3>Comments</h3>
After reviewing the code we saw that a lot of comments were spread through it. Most of them intended to improve the communication
between group members and not really to explain the code, and when the comments were actually meant to explain some code, after refactoring
the code had become simple enough without the comments, so we decided to erase all of them.

<h3>Duplicate Code</h3>
In the Board class we used the refactor method Consolidate Duplicate Conditional Fragments as we found that we had two methods that
made really similar things, placeFlag and removeFlag. Instead of having that, we created only one method that joined them both, with
the addition of a simple if-else statement.

<h3>Data Class</h3>
Our MenuBox class was only designed to contain fields and methods to access them. In order further simplify the class, we turned it
into a Record type class as it matched perfectly with the requirements we had.


<h2>Couplers</h2>
<h3>Middle Man</h3>
This code smell was ubiquitous in the LanternaGUI class. Our first idea was to have a draw method for every type of element that we had
(drawBomb(), drawCell(), drawNumber(), etc), but in the refactor process we saw that those functions were unnecessary, as we had
a textDraw function. The only thing that these element drawers were doing was calling drawText with different arguments. To solve it
we deleted those methods, giving the Viewer of each element the responsibility of calling the drawText function with the appropriate
arguments.

### SELF-EVALUATION

- Pedro Valente : 33.3%
- João Alves : 33.4%
- João Ribeiro : 33.3%
