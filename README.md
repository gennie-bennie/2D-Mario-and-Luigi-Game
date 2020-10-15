# 2D-Mario-and-Luigi-Game

README

To pause or restart the game click on the ‘Pause’ and ‘Restart’ buttons at the top right of the screen. Use the prompt to continue or restart/quit the current game. 
To move Luigi, press ‘a’ to move left, press ‘w’ to jump, press ‘s’ to jump again (double jump), and press ‘d’ to move right.
To move mario, use the arrow keys



Project Description

Intended Animation: A game where characters, Mario and Luigi, collect coins for points and avoid ‘enemy’ characters with a given timer.

Objects Being Animated
Mario sprite - Main character class that moves using arrow keys. Mario can jump higher than luigi but can only jump once. 

Luigi sprite - Player 2 class that moves using WASD keys. Luigi can jump twice but has a lower vertical than Mario

Koopa sprite - A monster class that moves at a specified time. If the player touches the koopa, the player score will deplete rapidly.

We will implement sprites animations onto our classes so that the sprite will move accordingly to movement inputs.

We will implement a GUI interface that provides scoring for each player as well as buttons to interact with the game (play, pause, restart)

Rule Based: 
-Players earn score by collecting coins (via contact)
-Coins are randomly generated within a certain y range
-Characters will lose points if it touches the monster
-First player to reach 20 points will win the game

Code Description
Mario Sprite - Baimeng Ye
The mario sprites were taken from a single sprite sheet from DeviantArt, created by “Xander-son-of-Xereus”
Implemented x and y coordinate to position the character sprite
Added direction to adjust how the sprite faces
Implemented step (horizontal speed) and jump (vertical distance) 
Ground represents where the character should land, whether it’s on a platform or on the ground
Coins are collected using a counter called “coins”
Can only jump once so implemented a boolean called “hasJumped” to make sure that Mario can’t jump in midair

Luigi Sprite - Geneivie Nguyen
The luigi sprites was taken from a single sprite sheet from DeviantArt, created by RetroSpriteResources, and cut out and added into a 2D array
Luigi is able to double jump and collect coins
Challenges:
An unexpected challenge was cutting out each luigi sprite in order to create the images for the animation
Another challenge was getting luigi to double jump

Koopa Sprite - Manaswi Marri
The koopa sprite was made using three different koopa images from The Spriters Resource website that were then converted to gif images and compiled within the code to create a sprite
The koopa sprite includes an Array of PImages as well as display and move methods 
Buttons - Manaswi Marri
The game includes play, pause, and quit interfaces so that the user can pause and restart the game whenever they want to. 

Coin Class - Geneivie Nguyen
The coin class creates a coin for each character to collect
It disappears and reappears after a character touches it
Some challenges included resizing it, making it disappear and reappear in different places, and to tally up the scores for each player

Platform Class - Baimeng Ye
The platform is a single rectangle that allows the character to reach coins or avoid the enemy koopa
Implemented “Aboveplatform” method to make sure the character is above the platform. This allows the “ground” variable of the character to reset and match the platform y coordinate


Extra Credit
Pause Screen - Click on the pause button at the top right of the screen to pause the game. 
Animated Sprites - all moving characters on screen are animated sprites
Animated Artifact - movie made using .tif files from saveFrame method


Work Division
Mario - Baimeng Ye
Luigi - Geneivie Nguyen
Koopa - Manaswi Marri
Music - Baimeng Ye
GUI (with Pause Screen) - Manaswi Marri 
Background - Baimeng Ye
Platform - Baimeng Ye
Coins - Geneivie Nguyen


