# Coursework-SEP-Seeter
Software Engineering practice Seeter files and work

# srudent id number
student id: 16040776

# purpose 
to refactor the code provided using primarily command design pattern but also model view controller

# what it does?
allows users to create a new 'seet' which is a list of messages associated with a topic and a user that creates and adds to the topic.

# functionality 
create a new topic with 'compose [enter topic]'
add strings to this new topic using 'body [enter String]', can use 'body' more that once to create a list of messages associated with topic
once done send the new topic to a server with 'send' command
can retrieve topics from server with 'fetch [enter topic]'
exit system with command 'exit'

# setup 
before using the seeter users must set up the server to do this go to the directory folder in which project is downloaded/stored
through the command line and run a command 'java -cp sep.seeter.server.Server 8888' the port number 8888 has to correspond to that
inputted into the client.
in the client pass the argument to the client a String user, String host, int port.
these inputs can be set up automatically through NerBeans by customizing the set configuration and passing those variables into 
arguments 'userid localhost 8888'

