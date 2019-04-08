package pubSub.server;

import baseEntities.IEntity;

public interface IChannel extends IEntity<String> {

	/**
	 * @return the topic/name of the concrete implementation of Channel
	 */
	String getChannelTopic();

}