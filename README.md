# THE ULTIMATE BATTLE SIMULATOR

## How to play 

In this game, you'll be able to challenge your friends to a Warriors and Wizards battle. First, you'll have to create your party either manually if you want to personalize every aspect of it or either randomly trusting the computer's choice. There are two options to create the party manually: directly inside the game or importing a CSV file if you already have a winning party you trust saved. 

Once you and your opponent have created the parties, the battle begins. You'll only have to choose the brave fighter who'll fight for the party and its life in a duel against a fighter from your opponent's party. The battle will be by rounds and in each round, each of them will choose an attack automatically depending on their stats. The combat will extend until one of them dies. The losing party will lose the dead fighter, who will be sent to the graveyard. The winner will be sent back to the winning party.

The game will run until one of the parties loses all its members and a winner is declared. The winner then will have the option to export its winner party to a CSV file in case wanting to use it in further games. Then, you'll have to decide either to get revenge or to exit the game. Hope you enjoy it!

**The game is ready to be played, just run the file main and have fun!**

## Technical aspects

The game is entirely based on the MainMenu class and its showMainMenu() method. This method contains the structure of the whole game and uses every method inside the project, both from the same class and outside the class. The methods inside the same class are mostly related to the usability of the game and guiding the user through the game.

The methods contained in MenuHelp class ask and receive information from the user or show information to the user.

Player class is referred to the user, its profile inside the game and the methods linked to it.

Graveyard class contains all the methods involved with the graveyard.

Battle class is referred to all the methods regarding a battle between 2 fighters: both the ones that keep track of the battle log and the act of battling itself.

GameUtils class contains different methods regarding parties: both for creating different types of parties and for exporting a party.

Warrior and Wizard classes are Character's extended classes and both implement Attacker interface. The only differences between them are the stats ranges and the way of attacking.  

The methods in Arts class have inside them all the drawings illustrate the game.

MusicPlayer class contains a music player so that music plays while using the game.

TextColor class is a library of different colors for the log to be printed out.




*This battle simulator was developed using java.*

A project by Núria Mafé, Olatz Izagirre, Paula Kamisato and Beatriz Pérez.

Link to our trello board : https://trello.com/b/s2UXKS90/homework1

