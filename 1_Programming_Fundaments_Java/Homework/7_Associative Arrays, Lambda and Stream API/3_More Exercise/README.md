## Task 1. Ranking

Here comes the final and the most interesting part - the Final ranking of the candidate interns. The final ranking is determined by the points of the interview tasks and from the exams in SoftUni. Here is your final task. You will receive some lines of input in the format "{contest}:{password for contest}" until you receive "end of contests". Save that data because you will need it later. After that, you will receive another type of input in the format "{contest}=>{password}=>{username}=>{points}" until you receive "end of submissions". Here is what you need to do:

· Check if the contest is valid (if you received it in the first type of input);

· Check if the password is correct for the given contest;

· Save the user with the contest they take part in (a user can take part in many contests) and the points the user has in the given contest. If you receive the same contest and the same user, update the points only if the new ones are more than the older ones.

In the end, you have to print the info for the user with the most points in the format "Best candidate is {user} with total {total points} points.". After that, print all students ordered by their names. For each user, print each contest with the points in descending order. See the examples.



## Task 2. Judge

You know the Judge system, right?! Your job is to create a program similar to the Judge system.

You will receive several input lines in the following format:

"{username} -> {contest} -> {points}"

The constestName and username are strings. The given points will be an integer number. You need to keep track of every contest and individual statistics of every user. You should check if such a contest already exists, and if not, add it, otherwise, check if the current user is participating in the contest. If he is participating, take the higher score, otherwise, just add it.

Also, you need to keep individual statistics for each user - the total points of all contests.

You should end your program when you receive the command "no more time". At that point, you should print each contest in order of input. For each contest, print the participants ordered by points in descending order and then by name in ascending order. After that, you should print individual statistics for every participant ordered by total points in descending order and then by alphabetical order.



## Task 3. MOBA Challenger

Peter is a pro MOBA player. He is struggling to become a master of the Challenger tier. So he watches the statistics in the tier carefully.

You will receive several input lines in one of the following formats:

"{player} -> {position} -> {skill}"

"{player} vs {player}"

The player and position are strings. The given skill will be an integer number. You need to keep track of every player.

When you receive a player and his position and skill, add him to the player pool. If he isn't present, else add his position and skill or update his skill, only if the current position skill is lower than the new value.

If you receive "{player} vs {player}" and both players exist in the tier, they duel with the following rules:

Compare their positions, if they got at least one in common, the player with better total skill points wins, and the other is demoted from the tier -> remove him. If they have the same total skill points, the duel is a tie, and they both continue in the Season.

If they don't have positions in common, the duel isn't happening, and both continue in the Season.

You should end your program when you receive the command "Season end". At that point, you should print the players, ordered by total skill in descending order, then ordered by player name in ascending order. For each player print, their position and skill are ordered descending by skill and then by position name in ascending order.



## Task 4. Snowwhite

Snow White loves her dwarfs, but there are so many, and she doesn't know how to order them. Does she order them by name? Or by the color of their hat? Or by physics? She can't decide, so it's up to you to write a program that does it for her.

You will be receiving several input lines which contain data about dwarfs in the following format:

"{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}"

The dwarfName and the dwarfHatColor are strings. The dwarfPhysics is an integer.

You must store the dwarfs in your program. There are several rules, though:

· If 2 dwarfs have the same name but different hat colors, they should be considered different dwarfs, and you should store both of them.

· If 2 dwarfs have the same name and the same hat color, store the one with the higher physics.

When you receive the command "Once upon a time", the input ends. You must order the dwarfs by physics in descending order and then by the total count of dwarfs with the same hat color in descending order. Then you must print them all.