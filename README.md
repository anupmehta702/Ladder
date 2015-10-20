# Ladder
Ladder Test

How to run the program :-
Run Test.java present at location package com.ideas.test;

It would ask you for necessary details and would autorun the players using math.random for  for every player's dice throw.

It would run the program unless it finds a winner which would abort the other players.

Feature List :-

1)Provides individual player history regarding the location he was visited during the coure of the game.
2)At any given point of time ,we could check the status of other players.
3) Auto detect recursive special squares(ladder & snake) and move the player accordingly .
For example ,player moves from 30 to 34 on dice rolled with value 4. If 34 has a snake which would move the player to
20 (for example) and 20 has a ladder to 28 ,so accordingly it would detect recursive special squares and move the player accordingly.
3)Validations for snake & ladder properties .
4)Code open for extention and special sqaure facility 


Refer below for sample output :-

Please enter no of squares on the board ::
10
Please enter snake Details ::
No of snakes to add ::
2
Please enter snake Details in format --> 'to from' ::
1 th snake[from,to] ::
8 6
2 th snake[from,to] ::
5 2
Please enter ladder Details ::
No of ladder to add ::
1
Please enter ladder Details in format --> 'to from' ::
1 th ladder[from,to] ::
3 4
--------------------
Default [from=1]
Default [from=2]
LADDER  [from=3, to=4]
Default [from=4]
SNAKE   [from=5, to=2]
Default [from=6]
Default [from=7]
SNAKE   [from=8, to=6]
Default [from=9]
Default [from=10]
--------------------
Please enter no of players  ::
2
Enter first player's name ::
ONE
Enter first player's name ::
TWO
Press Y to start the game ::
Y
--------------------------------------
Player :: ONE 's turn
Dice rolled to number ::3
Moved from ::1 to ::4
--------------------------------------
Player :: TWO 's turn
Dice rolled to number ::2
Moved from ::1 to ::3
Ladder detected .Player moved from -->3 to -->4
--------------------------------------
Player :: ONE 's turn
Dice rolled to number ::2
Moved from ::4 to ::6
--------------------------------------
Player :: TWO 's turn
Dice rolled to number ::2
Moved from ::4 to ::6
--------------------------------------
Player :: ONE 's turn
Dice rolled to number ::3
Moved from ::6 to ::9
--------------------------------------
Player :: TWO 's turn
Dice rolled to number ::1
Moved from ::6 to ::7
--------------------------------------
Player :: ONE 's turn
Dice rolled to number ::1
Moved from ::9 to ::10

Player :: ONE has finished the game !!

PlayerONE's moves [1--> 4--> 6--> 9--> 10-->  ]
Current location of all players ::
Player [name=ONE, square=10, sequenceNumber=7]Player [name=TWO, square=7, sequenceNumber=8]


