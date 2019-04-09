# CS2212 PubSubServer

Authors: Quincey James, Michael Giancola, Zhilong Zhang, Talon Zhu, Riley Black

-----

## Assignment Infomation
- Administered By: Proffessor Kostas Kontogiannis
- Administered At: Western University
- Administered On: Winter 2019

### Purpose
To practice creating a Software Requirements Specification and Software Design Description documents. We also needed to change the provided base-code to implement as many design patterns as possible.

### Design Patterns Implemented
- The Singleton
- The Proxy
- The Facade
- The Observer
- The Stategy
- The State
- The Chain of Responsibility
- The Iterator

## Introduction
This project is about the specification, design and implementation of a simple publish subscribe system.  The system may be simple in the operations it offers, but it provides ample opportunities to exercise your design skills, and practice the material presented in class. More specifically, you are expected to implement and use a number of design patterns including the Singleton, the State, the Strategy, the Proxy, and the Observer design patterns. 

## What is a publish-subscribe system
A publish-subscribe system (pub/sub system) is a system composed of publishers and subscribers. The publishers generate events and post them on a shared medium (i.e. the channel), where many subscribers have access to. The publishers do not know, and do not need to know, who the subscribers in the system are, and who consumes the published events. Publishers just generate events that are sent to a channel. For our project, the channel, on which a publisher publishes its messages is determined by the strategy the publisher is associated with. We consider that events have a type. Similarly, subscribers subscribe to specific channels, in order to get access to the events posted in those channels. A channel knows its subscribers and notifies them when a new event is posted in the channel. Upon reception of an event, subscribers may perform an action, depending on their state. A good description of the pub/sub architectural style can be found at: https://en.wikipedia.org/wiki/Publish%E2%80%93subscribe_pattern, and https://docs.oracle.com/cd/B10501_01/appdev.920/a96590/adg15pub.htm 

## System Actors and Entities
### Publisher: 
An entity that publishes/posts events to one or more channels. A publisher publishes an event to a channel based on a strategy, or to a default channel(s) if the no specific strategy is selected. 
### Subscriber: 
An entity that handles events published on a channel. A subscriber is subscribing to one or more channels. A subscriber has a “state” which determines how it handles an event.
### Channel: 
An entity that denotes an abstraction of a communication medium. It maintains a list of subscribers, and a queue of events. Once an event is added to the queue, the channel notifies its subscribers. There may be more than one channels in the system. 
### Event: 
An entity that denotes a piece of information posted on a channel. An event has an event ID, a reference to its publisher, and a payload which is an EventMessage object. The EventMessage has a header and a body.

## Java-doc
The Java-doc generated for this project can be viewed here: https://quinceyjames.github.io/CS2212-PubSubServer/
