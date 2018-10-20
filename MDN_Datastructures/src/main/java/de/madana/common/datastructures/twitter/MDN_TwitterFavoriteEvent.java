/*******************************************************************************
 * Copyright (C) 2018 MADANA
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @organization:MADANA
 * @author:Jean-Fabian Wenisch
 * @contact:dev@madana.io
 ******************************************************************************/
package de.madana.common.datastructures.twitter;
// TODO: Auto-generated Javadoc

/**
 * The Class MDN_TwitterFavoriteEvent.
 */
public  class MDN_TwitterFavoriteEvent {
    
    /** The for user id. */
    public   String for_user_id;
    
    /** The favorite events. */
    public   Favorite_event favorite_events[];

    /**
     * Instantiates a new MD N twitter favorite event.
     *
     * @param for_user_id the for user id
     * @param favorite_events the favorite events
     */
    public MDN_TwitterFavoriteEvent(String for_user_id, Favorite_event[] favorite_events){
        this.for_user_id = for_user_id;
        this.favorite_events = favorite_events;
    }

    /**
     * Gets the for user id.
     *
     * @return the for user id
     */
    public String getFor_user_id() {
		return for_user_id;
	}

	/**
	 * Sets the for user id.
	 *
	 * @param for_user_id the new for user id
	 */
	public void setFor_user_id(String for_user_id) {
		this.for_user_id = for_user_id;
	}

	/**
	 * Gets the favorite events.
	 *
	 * @return the favorite events
	 */
	public Favorite_event[] getFavorite_events() {
		return favorite_events;
	}

	/**
	 * Sets the favorite events.
	 *
	 * @param favorite_events the new favorite events
	 */
	public void setFavorite_events(Favorite_event[] favorite_events) {
		this.favorite_events = favorite_events;
	}

	/**
	 * Instantiates a new MD N twitter favorite event.
	 */
	public MDN_TwitterFavoriteEvent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The Class Favorite_event.
	 */
	public static   class Favorite_event {
        
        /** The id. */
        public   String id;
        
        /** The created at. */
        public   String created_at;
        
        /**
         * Gets the id.
         *
         * @return the id
         */
        public String getId() {
			return id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Gets the created at.
		 *
		 * @return the created at
		 */
		public String getCreated_at() {
			return created_at;
		}

		/**
		 * Sets the created at.
		 *
		 * @param created_at the new created at
		 */
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}

		/**
		 * Gets the timestamp ms.
		 *
		 * @return the timestamp ms
		 */
		public long getTimestamp_ms() {
			return timestamp_ms;
		}

		/**
		 * Sets the timestamp ms.
		 *
		 * @param timestamp_ms the new timestamp ms
		 */
		public void setTimestamp_ms(long timestamp_ms) {
			this.timestamp_ms = timestamp_ms;
		}

		/**
		 * Gets the favorited status.
		 *
		 * @return the favorited status
		 */
		public Favorited_status getFavorited_status() {
			return favorited_status;
		}

		/**
		 * Sets the favorited status.
		 *
		 * @param favorited_status the new favorited status
		 */
		public void setFavorited_status(Favorited_status favorited_status) {
			this.favorited_status = favorited_status;
		}

		/**
		 * Gets the user.
		 *
		 * @return the user
		 */
		public User getUser() {
			return user;
		}

		/**
		 * Sets the user.
		 *
		 * @param user the new user
		 */
		public void setUser(User user) {
			this.user = user;
		}

		/** The timestamp ms. */
		public   long timestamp_ms;
        
        /** The favorited status. */
        public   Favorited_status favorited_status;
        
        /** The user. */
        public   User user;

        /**
         * Instantiates a new favorite event.
         *
         * @param id the id
         * @param created_at the created at
         * @param timestamp_ms the timestamp ms
         * @param favorited_status the favorited status
         * @param user the user
         */
        public Favorite_event(String id, String created_at, long timestamp_ms, Favorited_status favorited_status, User user){
            this.id = id;
            this.created_at = created_at;
            this.timestamp_ms = timestamp_ms;
            this.favorited_status = favorited_status;
            this.user = user;
        }

        /**
         * The Class Favorited_status.
         */
        public static   class Favorited_status {
            
            /** The created at. */
            public   String created_at;
            
            /** The id. */
            public   long id;
            
            /**
             * Gets the created at.
             *
             * @return the created at
             */
            public String getCreated_at() {
				return created_at;
			}

			/**
			 * Sets the created at.
			 *
			 * @param created_at the new created at
			 */
			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			/**
			 * Gets the id.
			 *
			 * @return the id
			 */
			public long getId() {
				return id;
			}

			/**
			 * Sets the id.
			 *
			 * @param id the new id
			 */
			public void setId(long id) {
				this.id = id;
			}

			/**
			 * Gets the id str.
			 *
			 * @return the id str
			 */
			public String getId_str() {
				return id_str;
			}

			/**
			 * Sets the id str.
			 *
			 * @param id_str the new id str
			 */
			public void setId_str(String id_str) {
				this.id_str = id_str;
			}

			/**
			 * Gets the text.
			 *
			 * @return the text
			 */
			public String getText() {
				return text;
			}

			/**
			 * Sets the text.
			 *
			 * @param text the new text
			 */
			public void setText(String text) {
				this.text = text;
			}

			/**
			 * Gets the source.
			 *
			 * @return the source
			 */
			public String getSource() {
				return source;
			}

			/**
			 * Sets the source.
			 *
			 * @param source the new source
			 */
			public void setSource(String source) {
				this.source = source;
			}

			/**
			 * Checks if is truncated.
			 *
			 * @return true, if is truncated
			 */
			public boolean isTruncated() {
				return truncated;
			}

			/**
			 * Sets the truncated.
			 *
			 * @param truncated the new truncated
			 */
			public void setTruncated(boolean truncated) {
				this.truncated = truncated;
			}

			/**
			 * Gets the in reply to status id.
			 *
			 * @return the in reply to status id
			 */
			public In_reply_to_status_id getIn_reply_to_status_id() {
				return in_reply_to_status_id;
			}

			/**
			 * Sets the in reply to status id.
			 *
			 * @param in_reply_to_status_id the new in reply to status id
			 */
			public void setIn_reply_to_status_id(In_reply_to_status_id in_reply_to_status_id) {
				this.in_reply_to_status_id = in_reply_to_status_id;
			}

			/**
			 * Gets the in reply to status id str.
			 *
			 * @return the in reply to status id str
			 */
			public In_reply_to_status_id_str getIn_reply_to_status_id_str() {
				return in_reply_to_status_id_str;
			}

			/**
			 * Sets the in reply to status id str.
			 *
			 * @param in_reply_to_status_id_str the new in reply to status id str
			 */
			public void setIn_reply_to_status_id_str(In_reply_to_status_id_str in_reply_to_status_id_str) {
				this.in_reply_to_status_id_str = in_reply_to_status_id_str;
			}

			/**
			 * Gets the in reply to user id.
			 *
			 * @return the in reply to user id
			 */
			public In_reply_to_user_id getIn_reply_to_user_id() {
				return in_reply_to_user_id;
			}

			/**
			 * Sets the in reply to user id.
			 *
			 * @param in_reply_to_user_id the new in reply to user id
			 */
			public void setIn_reply_to_user_id(In_reply_to_user_id in_reply_to_user_id) {
				this.in_reply_to_user_id = in_reply_to_user_id;
			}

			/**
			 * Gets the in reply to user id str.
			 *
			 * @return the in reply to user id str
			 */
			public In_reply_to_user_id_str getIn_reply_to_user_id_str() {
				return in_reply_to_user_id_str;
			}

			/**
			 * Sets the in reply to user id str.
			 *
			 * @param in_reply_to_user_id_str the new in reply to user id str
			 */
			public void setIn_reply_to_user_id_str(In_reply_to_user_id_str in_reply_to_user_id_str) {
				this.in_reply_to_user_id_str = in_reply_to_user_id_str;
			}

			/**
			 * Gets the in reply to screen name.
			 *
			 * @return the in reply to screen name
			 */
			public In_reply_to_screen_name getIn_reply_to_screen_name() {
				return in_reply_to_screen_name;
			}

			/**
			 * Sets the in reply to screen name.
			 *
			 * @param in_reply_to_screen_name the new in reply to screen name
			 */
			public void setIn_reply_to_screen_name(In_reply_to_screen_name in_reply_to_screen_name) {
				this.in_reply_to_screen_name = in_reply_to_screen_name;
			}

			/**
			 * Gets the user.
			 *
			 * @return the user
			 */
			public User getUser() {
				return user;
			}

			/**
			 * Sets the user.
			 *
			 * @param user the new user
			 */
			public void setUser(User user) {
				this.user = user;
			}

			/**
			 * Gets the geo.
			 *
			 * @return the geo
			 */
			public Geo getGeo() {
				return geo;
			}

			/**
			 * Sets the geo.
			 *
			 * @param geo the new geo
			 */
			public void setGeo(Geo geo) {
				this.geo = geo;
			}

			/**
			 * Gets the coordinates.
			 *
			 * @return the coordinates
			 */
			public Coordinates getCoordinates() {
				return coordinates;
			}

			/**
			 * Sets the coordinates.
			 *
			 * @param coordinates the new coordinates
			 */
			public void setCoordinates(Coordinates coordinates) {
				this.coordinates = coordinates;
			}

			/**
			 * Gets the place.
			 *
			 * @return the place
			 */
			public Place getPlace() {
				return place;
			}

			/**
			 * Sets the place.
			 *
			 * @param place the new place
			 */
			public void setPlace(Place place) {
				this.place = place;
			}

			/**
			 * Gets the contributors.
			 *
			 * @return the contributors
			 */
			public Contributors getContributors() {
				return contributors;
			}

			/**
			 * Sets the contributors.
			 *
			 * @param contributors the new contributors
			 */
			public void setContributors(Contributors contributors) {
				this.contributors = contributors;
			}

			/**
			 * Checks if is checks if is quote status.
			 *
			 * @return true, if is checks if is quote status
			 */
			public boolean isIs_quote_status() {
				return is_quote_status;
			}

			/**
			 * Sets the checks if is quote status.
			 *
			 * @param is_quote_status the new checks if is quote status
			 */
			public void setIs_quote_status(boolean is_quote_status) {
				this.is_quote_status = is_quote_status;
			}

			/**
			 * Gets the extended tweet.
			 *
			 * @return the extended tweet
			 */
			public Extended_tweet getExtended_tweet() {
				return extended_tweet;
			}

			/**
			 * Sets the extended tweet.
			 *
			 * @param extended_tweet the new extended tweet
			 */
			public void setExtended_tweet(Extended_tweet extended_tweet) {
				this.extended_tweet = extended_tweet;
			}

			/**
			 * Gets the quote count.
			 *
			 * @return the quote count
			 */
			public long getQuote_count() {
				return quote_count;
			}

			/**
			 * Sets the quote count.
			 *
			 * @param quote_count the new quote count
			 */
			public void setQuote_count(long quote_count) {
				this.quote_count = quote_count;
			}

			/**
			 * Gets the reply count.
			 *
			 * @return the reply count
			 */
			public long getReply_count() {
				return reply_count;
			}

			/**
			 * Sets the reply count.
			 *
			 * @param reply_count the new reply count
			 */
			public void setReply_count(long reply_count) {
				this.reply_count = reply_count;
			}

			/**
			 * Gets the retweet count.
			 *
			 * @return the retweet count
			 */
			public long getRetweet_count() {
				return retweet_count;
			}

			/**
			 * Sets the retweet count.
			 *
			 * @param retweet_count the new retweet count
			 */
			public void setRetweet_count(long retweet_count) {
				this.retweet_count = retweet_count;
			}

			/**
			 * Gets the favorite count.
			 *
			 * @return the favorite count
			 */
			public long getFavorite_count() {
				return favorite_count;
			}

			/**
			 * Sets the favorite count.
			 *
			 * @param favorite_count the new favorite count
			 */
			public void setFavorite_count(long favorite_count) {
				this.favorite_count = favorite_count;
			}

			/**
			 * Gets the entities.
			 *
			 * @return the entities
			 */
			public Entities getEntities() {
				return entities;
			}

			/**
			 * Sets the entities.
			 *
			 * @param entities the new entities
			 */
			public void setEntities(Entities entities) {
				this.entities = entities;
			}

			/**
			 * Checks if is favorited.
			 *
			 * @return true, if is favorited
			 */
			public boolean isFavorited() {
				return favorited;
			}

			/**
			 * Sets the favorited.
			 *
			 * @param favorited the new favorited
			 */
			public void setFavorited(boolean favorited) {
				this.favorited = favorited;
			}

			/**
			 * Checks if is retweeted.
			 *
			 * @return true, if is retweeted
			 */
			public boolean isRetweeted() {
				return retweeted;
			}

			/**
			 * Sets the retweeted.
			 *
			 * @param retweeted the new retweeted
			 */
			public void setRetweeted(boolean retweeted) {
				this.retweeted = retweeted;
			}

			/**
			 * Checks if is possibly sensitive.
			 *
			 * @return true, if is possibly sensitive
			 */
			public boolean isPossibly_sensitive() {
				return possibly_sensitive;
			}

			/**
			 * Sets the possibly sensitive.
			 *
			 * @param possibly_sensitive the new possibly sensitive
			 */
			public void setPossibly_sensitive(boolean possibly_sensitive) {
				this.possibly_sensitive = possibly_sensitive;
			}

			/**
			 * Gets the filter level.
			 *
			 * @return the filter level
			 */
			public String getFilter_level() {
				return filter_level;
			}

			/**
			 * Sets the filter level.
			 *
			 * @param filter_level the new filter level
			 */
			public void setFilter_level(String filter_level) {
				this.filter_level = filter_level;
			}

			/**
			 * Gets the lang.
			 *
			 * @return the lang
			 */
			public String getLang() {
				return lang;
			}

			/**
			 * Sets the lang.
			 *
			 * @param lang the new lang
			 */
			public void setLang(String lang) {
				this.lang = lang;
			}

			/** The id str. */
			public   String id_str;
            
            /** The text. */
            public   String text;
            
            /** The source. */
            public   String source;
            
            /** The truncated. */
            public   boolean truncated;
            
            /** The in reply to status id. */
            public   In_reply_to_status_id in_reply_to_status_id;
            
            /** The in reply to status id str. */
            public   In_reply_to_status_id_str in_reply_to_status_id_str;
            
            /** The in reply to user id. */
            public   In_reply_to_user_id in_reply_to_user_id;
            
            /** The in reply to user id str. */
            public   In_reply_to_user_id_str in_reply_to_user_id_str;
            
            /** The in reply to screen name. */
            public   In_reply_to_screen_name in_reply_to_screen_name;
            
            /** The user. */
            public   User user;
            
            /** The geo. */
            public   Geo geo;
            
            /** The coordinates. */
            public   Coordinates coordinates;
            
            /** The place. */
            public   Place place;
            
            /** The contributors. */
            public   Contributors contributors;
            
            /** The is quote status. */
            public   boolean is_quote_status;
            
            /** The extended tweet. */
            public   Extended_tweet extended_tweet;
            
            /** The quote count. */
            public   long quote_count;
            
            /** The reply count. */
            public   long reply_count;
            
            /** The retweet count. */
            public   long retweet_count;
            
            /** The favorite count. */
            public   long favorite_count;
            
            /** The entities. */
            public   Entities entities;
            
            /** The favorited. */
            public   boolean favorited;
            
            /** The retweeted. */
            public   boolean retweeted;
            
            /** The possibly sensitive. */
            public   boolean possibly_sensitive;
            
            /** The filter level. */
            public   String filter_level;
            
            /** The lang. */
            public   String lang;
    
            /**
             * Instantiates a new favorited status.
             *
             * @param created_at the created at
             * @param id the id
             * @param id_str the id str
             * @param text the text
             * @param source the source
             * @param truncated the truncated
             * @param in_reply_to_status_id the in reply to status id
             * @param in_reply_to_status_id_str the in reply to status id str
             * @param in_reply_to_user_id the in reply to user id
             * @param in_reply_to_user_id_str the in reply to user id str
             * @param in_reply_to_screen_name the in reply to screen name
             * @param user the user
             * @param geo the geo
             * @param coordinates the coordinates
             * @param place the place
             * @param contributors the contributors
             * @param is_quote_status the is quote status
             * @param extended_tweet the extended tweet
             * @param quote_count the quote count
             * @param reply_count the reply count
             * @param retweet_count the retweet count
             * @param favorite_count the favorite count
             * @param entities the entities
             * @param favorited the favorited
             * @param retweeted the retweeted
             * @param possibly_sensitive the possibly sensitive
             * @param filter_level the filter level
             * @param lang the lang
             */
            public Favorited_status(String created_at, long id, String id_str, String text, String source, boolean truncated, In_reply_to_status_id in_reply_to_status_id, In_reply_to_status_id_str in_reply_to_status_id_str, In_reply_to_user_id in_reply_to_user_id, In_reply_to_user_id_str in_reply_to_user_id_str, In_reply_to_screen_name in_reply_to_screen_name, User user, Geo geo, Coordinates coordinates, Place place, Contributors contributors, boolean is_quote_status, Extended_tweet extended_tweet, long quote_count, long reply_count, long retweet_count, long favorite_count, Entities entities, boolean favorited, boolean retweeted, boolean possibly_sensitive, String filter_level, String lang){
                this.created_at = created_at;
                this.id = id;
                this.id_str = id_str;
                this.text = text;
                this.source = source;
                this.truncated = truncated;
                this.in_reply_to_status_id = in_reply_to_status_id;
                this.in_reply_to_status_id_str = in_reply_to_status_id_str;
                this.in_reply_to_user_id = in_reply_to_user_id;
                this.in_reply_to_user_id_str = in_reply_to_user_id_str;
                this.in_reply_to_screen_name = in_reply_to_screen_name;
                this.user = user;
                this.geo = geo;
                this.coordinates = coordinates;
                this.place = place;
                this.contributors = contributors;
                this.is_quote_status = is_quote_status;
                this.extended_tweet = extended_tweet;
                this.quote_count = quote_count;
                this.reply_count = reply_count;
                this.retweet_count = retweet_count;
                this.favorite_count = favorite_count;
                this.entities = entities;
                this.favorited = favorited;
                this.retweeted = retweeted;
                this.possibly_sensitive = possibly_sensitive;
                this.filter_level = filter_level;
                this.lang = lang;
            }
    
            /**
             * The Class In_reply_to_status_id.
             */
            public static   class In_reply_to_status_id {
        
                /**
                 * Instantiates a new in reply to status id.
                 */
                public In_reply_to_status_id(){
                }
            }
    
            /**
             * The Class In_reply_to_status_id_str.
             */
            public static   class In_reply_to_status_id_str {
        
                /**
                 * Instantiates a new in reply to status id str.
                 */
                public In_reply_to_status_id_str(){
                }
            }
    
            /**
             * The Class In_reply_to_user_id.
             */
            public static   class In_reply_to_user_id {
        
                /**
                 * Instantiates a new in reply to user id.
                 */
                public In_reply_to_user_id(){
                }
            }
    
            /**
             * The Class In_reply_to_user_id_str.
             */
            public static   class In_reply_to_user_id_str {
        
                /**
                 * Instantiates a new in reply to user id str.
                 */
                public In_reply_to_user_id_str(){
                }
            }
    
            /**
             * The Class In_reply_to_screen_name.
             */
            public static   class In_reply_to_screen_name {
        
                /**
                 * Instantiates a new in reply to screen name.
                 */
                public In_reply_to_screen_name(){
                }
            }
    
            /**
             * The Class User.
             */
            public static   class User {
                
                /** The id. */
                public   long id;
                
                /** The id str. */
                public   String id_str;
                
                /** The name. */
                public   String name;
                
                /**
                 * Gets the id.
                 *
                 * @return the id
                 */
                public long getId() {
					return id;
				}

				/**
				 * Sets the id.
				 *
				 * @param id the new id
				 */
				public void setId(long id) {
					this.id = id;
				}

				/**
				 * Gets the id str.
				 *
				 * @return the id str
				 */
				public String getId_str() {
					return id_str;
				}

				/**
				 * Sets the id str.
				 *
				 * @param id_str the new id str
				 */
				public void setId_str(String id_str) {
					this.id_str = id_str;
				}

				/**
				 * Gets the name.
				 *
				 * @return the name
				 */
				public String getName() {
					return name;
				}

				/**
				 * Sets the name.
				 *
				 * @param name the new name
				 */
				public void setName(String name) {
					this.name = name;
				}

				/**
				 * Gets the screen name.
				 *
				 * @return the screen name
				 */
				public String getScreen_name() {
					return screen_name;
				}

				/**
				 * Sets the screen name.
				 *
				 * @param screen_name the new screen name
				 */
				public void setScreen_name(String screen_name) {
					this.screen_name = screen_name;
				}

				/**
				 * Gets the location.
				 *
				 * @return the location
				 */
				public String getLocation() {
					return location;
				}

				/**
				 * Sets the location.
				 *
				 * @param location the new location
				 */
				public void setLocation(String location) {
					this.location = location;
				}

				/**
				 * Gets the url.
				 *
				 * @return the url
				 */
				public String getUrl() {
					return url;
				}

				/**
				 * Sets the url.
				 *
				 * @param url the new url
				 */
				public void setUrl(String url) {
					this.url = url;
				}

				/**
				 * Gets the description.
				 *
				 * @return the description
				 */
				public String getDescription() {
					return description;
				}

				/**
				 * Sets the description.
				 *
				 * @param description the new description
				 */
				public void setDescription(String description) {
					this.description = description;
				}

				/**
				 * Gets the translator type.
				 *
				 * @return the translator type
				 */
				public String getTranslator_type() {
					return translator_type;
				}

				/**
				 * Sets the translator type.
				 *
				 * @param translator_type the new translator type
				 */
				public void setTranslator_type(String translator_type) {
					this.translator_type = translator_type;
				}

				/**
				 * Checks if is protected.
				 *
				 * @return true, if is protected
				 */
				public boolean is_protected() {
					return _protected;
				}

				/**
				 * Sets the protected.
				 *
				 * @param _protected the new protected
				 */
				public void set_protected(boolean _protected) {
					this._protected = _protected;
				}

				/**
				 * Checks if is verified.
				 *
				 * @return true, if is verified
				 */
				public boolean isVerified() {
					return verified;
				}

				/**
				 * Sets the verified.
				 *
				 * @param verified the new verified
				 */
				public void setVerified(boolean verified) {
					this.verified = verified;
				}

				/**
				 * Gets the followers count.
				 *
				 * @return the followers count
				 */
				public long getFollowers_count() {
					return followers_count;
				}

				/**
				 * Sets the followers count.
				 *
				 * @param followers_count the new followers count
				 */
				public void setFollowers_count(long followers_count) {
					this.followers_count = followers_count;
				}

				/**
				 * Gets the friends count.
				 *
				 * @return the friends count
				 */
				public long getFriends_count() {
					return friends_count;
				}

				/**
				 * Sets the friends count.
				 *
				 * @param friends_count the new friends count
				 */
				public void setFriends_count(long friends_count) {
					this.friends_count = friends_count;
				}

				/**
				 * Gets the listed count.
				 *
				 * @return the listed count
				 */
				public long getListed_count() {
					return listed_count;
				}

				/**
				 * Sets the listed count.
				 *
				 * @param listed_count the new listed count
				 */
				public void setListed_count(long listed_count) {
					this.listed_count = listed_count;
				}

				/**
				 * Gets the favourites count.
				 *
				 * @return the favourites count
				 */
				public long getFavourites_count() {
					return favourites_count;
				}

				/**
				 * Sets the favourites count.
				 *
				 * @param favourites_count the new favourites count
				 */
				public void setFavourites_count(long favourites_count) {
					this.favourites_count = favourites_count;
				}

				/**
				 * Gets the statuses count.
				 *
				 * @return the statuses count
				 */
				public long getStatuses_count() {
					return statuses_count;
				}

				/**
				 * Sets the statuses count.
				 *
				 * @param statuses_count the new statuses count
				 */
				public void setStatuses_count(long statuses_count) {
					this.statuses_count = statuses_count;
				}

				/**
				 * Gets the created at.
				 *
				 * @return the created at
				 */
				public String getCreated_at() {
					return created_at;
				}

				/**
				 * Sets the created at.
				 *
				 * @param created_at the new created at
				 */
				public void setCreated_at(String created_at) {
					this.created_at = created_at;
				}

				/**
				 * Gets the utc offset.
				 *
				 * @return the utc offset
				 */
				public Utc_offset getUtc_offset() {
					return utc_offset;
				}

				/**
				 * Sets the utc offset.
				 *
				 * @param utc_offset the new utc offset
				 */
				public void setUtc_offset(Utc_offset utc_offset) {
					this.utc_offset = utc_offset;
				}

				/**
				 * Gets the time zone.
				 *
				 * @return the time zone
				 */
				public Time_zone getTime_zone() {
					return time_zone;
				}

				/**
				 * Sets the time zone.
				 *
				 * @param time_zone the new time zone
				 */
				public void setTime_zone(Time_zone time_zone) {
					this.time_zone = time_zone;
				}

				/**
				 * Checks if is geo enabled.
				 *
				 * @return true, if is geo enabled
				 */
				public boolean isGeo_enabled() {
					return geo_enabled;
				}

				/**
				 * Sets the geo enabled.
				 *
				 * @param geo_enabled the new geo enabled
				 */
				public void setGeo_enabled(boolean geo_enabled) {
					this.geo_enabled = geo_enabled;
				}

				/**
				 * Gets the lang.
				 *
				 * @return the lang
				 */
				public String getLang() {
					return lang;
				}

				/**
				 * Sets the lang.
				 *
				 * @param lang the new lang
				 */
				public void setLang(String lang) {
					this.lang = lang;
				}

				/**
				 * Checks if is contributors enabled.
				 *
				 * @return true, if is contributors enabled
				 */
				public boolean isContributors_enabled() {
					return contributors_enabled;
				}

				/**
				 * Sets the contributors enabled.
				 *
				 * @param contributors_enabled the new contributors enabled
				 */
				public void setContributors_enabled(boolean contributors_enabled) {
					this.contributors_enabled = contributors_enabled;
				}

				/**
				 * Checks if is checks if is translator.
				 *
				 * @return true, if is checks if is translator
				 */
				public boolean isIs_translator() {
					return is_translator;
				}

				/**
				 * Sets the checks if is translator.
				 *
				 * @param is_translator the new checks if is translator
				 */
				public void setIs_translator(boolean is_translator) {
					this.is_translator = is_translator;
				}

				/**
				 * Gets the profile background color.
				 *
				 * @return the profile background color
				 */
				public String getProfile_background_color() {
					return profile_background_color;
				}

				/**
				 * Sets the profile background color.
				 *
				 * @param profile_background_color the new profile background color
				 */
				public void setProfile_background_color(String profile_background_color) {
					this.profile_background_color = profile_background_color;
				}

				/**
				 * Gets the profile background image url.
				 *
				 * @return the profile background image url
				 */
				public String getProfile_background_image_url() {
					return profile_background_image_url;
				}

				/**
				 * Sets the profile background image url.
				 *
				 * @param profile_background_image_url the new profile background image url
				 */
				public void setProfile_background_image_url(String profile_background_image_url) {
					this.profile_background_image_url = profile_background_image_url;
				}

				/**
				 * Gets the profile background image url https.
				 *
				 * @return the profile background image url https
				 */
				public String getProfile_background_image_url_https() {
					return profile_background_image_url_https;
				}

				/**
				 * Sets the profile background image url https.
				 *
				 * @param profile_background_image_url_https the new profile background image url https
				 */
				public void setProfile_background_image_url_https(String profile_background_image_url_https) {
					this.profile_background_image_url_https = profile_background_image_url_https;
				}

				/**
				 * Checks if is profile background tile.
				 *
				 * @return true, if is profile background tile
				 */
				public boolean isProfile_background_tile() {
					return profile_background_tile;
				}

				/**
				 * Sets the profile background tile.
				 *
				 * @param profile_background_tile the new profile background tile
				 */
				public void setProfile_background_tile(boolean profile_background_tile) {
					this.profile_background_tile = profile_background_tile;
				}

				/**
				 * Gets the profile link color.
				 *
				 * @return the profile link color
				 */
				public String getProfile_link_color() {
					return profile_link_color;
				}

				/**
				 * Sets the profile link color.
				 *
				 * @param profile_link_color the new profile link color
				 */
				public void setProfile_link_color(String profile_link_color) {
					this.profile_link_color = profile_link_color;
				}

				/**
				 * Gets the profile sidebar border color.
				 *
				 * @return the profile sidebar border color
				 */
				public String getProfile_sidebar_border_color() {
					return profile_sidebar_border_color;
				}

				/**
				 * Sets the profile sidebar border color.
				 *
				 * @param profile_sidebar_border_color the new profile sidebar border color
				 */
				public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
					this.profile_sidebar_border_color = profile_sidebar_border_color;
				}

				/**
				 * Gets the profile sidebar fill color.
				 *
				 * @return the profile sidebar fill color
				 */
				public String getProfile_sidebar_fill_color() {
					return profile_sidebar_fill_color;
				}

				/**
				 * Sets the profile sidebar fill color.
				 *
				 * @param profile_sidebar_fill_color the new profile sidebar fill color
				 */
				public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
					this.profile_sidebar_fill_color = profile_sidebar_fill_color;
				}

				/**
				 * Gets the profile text color.
				 *
				 * @return the profile text color
				 */
				public String getProfile_text_color() {
					return profile_text_color;
				}

				/**
				 * Sets the profile text color.
				 *
				 * @param profile_text_color the new profile text color
				 */
				public void setProfile_text_color(String profile_text_color) {
					this.profile_text_color = profile_text_color;
				}

				/**
				 * Checks if is profile use background image.
				 *
				 * @return true, if is profile use background image
				 */
				public boolean isProfile_use_background_image() {
					return profile_use_background_image;
				}

				/**
				 * Sets the profile use background image.
				 *
				 * @param profile_use_background_image the new profile use background image
				 */
				public void setProfile_use_background_image(boolean profile_use_background_image) {
					this.profile_use_background_image = profile_use_background_image;
				}

				/**
				 * Gets the profile image url.
				 *
				 * @return the profile image url
				 */
				public String getProfile_image_url() {
					return profile_image_url;
				}

				/**
				 * Sets the profile image url.
				 *
				 * @param profile_image_url the new profile image url
				 */
				public void setProfile_image_url(String profile_image_url) {
					this.profile_image_url = profile_image_url;
				}

				/**
				 * Gets the profile image url https.
				 *
				 * @return the profile image url https
				 */
				public String getProfile_image_url_https() {
					return profile_image_url_https;
				}

				/**
				 * Sets the profile image url https.
				 *
				 * @param profile_image_url_https the new profile image url https
				 */
				public void setProfile_image_url_https(String profile_image_url_https) {
					this.profile_image_url_https = profile_image_url_https;
				}

				/**
				 * Gets the profile banner url.
				 *
				 * @return the profile banner url
				 */
				public String getProfile_banner_url() {
					return profile_banner_url;
				}

				/**
				 * Sets the profile banner url.
				 *
				 * @param profile_banner_url the new profile banner url
				 */
				public void setProfile_banner_url(String profile_banner_url) {
					this.profile_banner_url = profile_banner_url;
				}

				/**
				 * Checks if is default profile.
				 *
				 * @return true, if is default profile
				 */
				public boolean isDefault_profile() {
					return default_profile;
				}

				/**
				 * Sets the default profile.
				 *
				 * @param default_profile the new default profile
				 */
				public void setDefault_profile(boolean default_profile) {
					this.default_profile = default_profile;
				}

				/**
				 * Checks if is default profile image.
				 *
				 * @return true, if is default profile image
				 */
				public boolean isDefault_profile_image() {
					return default_profile_image;
				}

				/**
				 * Sets the default profile image.
				 *
				 * @param default_profile_image the new default profile image
				 */
				public void setDefault_profile_image(boolean default_profile_image) {
					this.default_profile_image = default_profile_image;
				}

				/**
				 * Gets the following.
				 *
				 * @return the following
				 */
				public Following getFollowing() {
					return following;
				}

				/**
				 * Sets the following.
				 *
				 * @param following the new following
				 */
				public void setFollowing(Following following) {
					this.following = following;
				}

				/**
				 * Gets the follow request sent.
				 *
				 * @return the follow request sent
				 */
				public Follow_request_sent getFollow_request_sent() {
					return follow_request_sent;
				}

				/**
				 * Sets the follow request sent.
				 *
				 * @param follow_request_sent the new follow request sent
				 */
				public void setFollow_request_sent(Follow_request_sent follow_request_sent) {
					this.follow_request_sent = follow_request_sent;
				}

				/**
				 * Gets the notifications.
				 *
				 * @return the notifications
				 */
				public Notifications getNotifications() {
					return notifications;
				}

				/**
				 * Sets the notifications.
				 *
				 * @param notifications the new notifications
				 */
				public void setNotifications(Notifications notifications) {
					this.notifications = notifications;
				}

				/** The screen name. */
				public   String screen_name;
                
                /** The location. */
                public   String location;
                
                /** The url. */
                public   String url;
                
                /** The description. */
                public   String description;
                
                /** The translator type. */
                public   String translator_type;
                
                /** The protected. */
                public   boolean _protected;
                
                /** The verified. */
                public   boolean verified;
                
                /** The followers count. */
                public   long followers_count;
                
                /** The friends count. */
                public   long friends_count;
                
                /** The listed count. */
                public   long listed_count;
                
                /** The favourites count. */
                public   long favourites_count;
                
                /** The statuses count. */
                public   long statuses_count;
                
                /** The created at. */
                public   String created_at;
                
                /** The utc offset. */
                public   Utc_offset utc_offset;
                
                /** The time zone. */
                public   Time_zone time_zone;
                
                /** The geo enabled. */
                public   boolean geo_enabled;
                
                /** The lang. */
                public   String lang;
                
                /** The contributors enabled. */
                public   boolean contributors_enabled;
                
                /** The is translator. */
                public   boolean is_translator;
                
                /** The profile background color. */
                public   String profile_background_color;
                
                /** The profile background image url. */
                public   String profile_background_image_url;
                
                /** The profile background image url https. */
                public   String profile_background_image_url_https;
                
                /** The profile background tile. */
                public   boolean profile_background_tile;
                
                /** The profile link color. */
                public   String profile_link_color;
                
                /** The profile sidebar border color. */
                public   String profile_sidebar_border_color;
                
                /** The profile sidebar fill color. */
                public   String profile_sidebar_fill_color;
                
                /** The profile text color. */
                public   String profile_text_color;
                
                /** The profile use background image. */
                public   boolean profile_use_background_image;
                
                /** The profile image url. */
                public   String profile_image_url;
                
                /** The profile image url https. */
                public   String profile_image_url_https;
                
                /** The profile banner url. */
                public   String profile_banner_url;
                
                /** The default profile. */
                public   boolean default_profile;
                
                /** The default profile image. */
                public   boolean default_profile_image;
                
                /** The following. */
                public   Following following;
                
                /** The follow request sent. */
                public   Follow_request_sent follow_request_sent;
                
                /** The notifications. */
                public   Notifications notifications;
        
                /**
                 * Instantiates a new user.
                 *
                 * @param id the id
                 * @param id_str the id str
                 * @param name the name
                 * @param screen_name the screen name
                 * @param location the location
                 * @param url the url
                 * @param description the description
                 * @param translator_type the translator type
                 * @param _protected the protected
                 * @param verified the verified
                 * @param followers_count the followers count
                 * @param friends_count the friends count
                 * @param listed_count the listed count
                 * @param favourites_count the favourites count
                 * @param statuses_count the statuses count
                 * @param created_at the created at
                 * @param utc_offset the utc offset
                 * @param time_zone the time zone
                 * @param geo_enabled the geo enabled
                 * @param lang the lang
                 * @param contributors_enabled the contributors enabled
                 * @param is_translator the is translator
                 * @param profile_background_color the profile background color
                 * @param profile_background_image_url the profile background image url
                 * @param profile_background_image_url_https the profile background image url https
                 * @param profile_background_tile the profile background tile
                 * @param profile_link_color the profile link color
                 * @param profile_sidebar_border_color the profile sidebar border color
                 * @param profile_sidebar_fill_color the profile sidebar fill color
                 * @param profile_text_color the profile text color
                 * @param profile_use_background_image the profile use background image
                 * @param profile_image_url the profile image url
                 * @param profile_image_url_https the profile image url https
                 * @param profile_banner_url the profile banner url
                 * @param default_profile the default profile
                 * @param default_profile_image the default profile image
                 * @param following the following
                 * @param follow_request_sent the follow request sent
                 * @param notifications the notifications
                 */
                public User(long id, String id_str, String name, String screen_name, String location, String url, String description, String translator_type, boolean _protected, boolean verified, long followers_count, long friends_count, long listed_count, long favourites_count, long statuses_count, String created_at, Utc_offset utc_offset, Time_zone time_zone, boolean geo_enabled, String lang, boolean contributors_enabled, boolean is_translator, String profile_background_color, String profile_background_image_url, String profile_background_image_url_https, boolean profile_background_tile, String profile_link_color, String profile_sidebar_border_color, String profile_sidebar_fill_color, String profile_text_color, boolean profile_use_background_image, String profile_image_url, String profile_image_url_https, String profile_banner_url, boolean default_profile, boolean default_profile_image, Following following, Follow_request_sent follow_request_sent, Notifications notifications){
                    this.id = id;
                    this.id_str = id_str;
                    this.name = name;
                    this.screen_name = screen_name;
                    this.location = location;
                    this.url = url;
                    this.description = description;
                    this.translator_type = translator_type;
                    this._protected = _protected;
                    this.verified = verified;
                    this.followers_count = followers_count;
                    this.friends_count = friends_count;
                    this.listed_count = listed_count;
                    this.favourites_count = favourites_count;
                    this.statuses_count = statuses_count;
                    this.created_at = created_at;
                    this.utc_offset = utc_offset;
                    this.time_zone = time_zone;
                    this.geo_enabled = geo_enabled;
                    this.lang = lang;
                    this.contributors_enabled = contributors_enabled;
                    this.is_translator = is_translator;
                    this.profile_background_color = profile_background_color;
                    this.profile_background_image_url = profile_background_image_url;
                    this.profile_background_image_url_https = profile_background_image_url_https;
                    this.profile_background_tile = profile_background_tile;
                    this.profile_link_color = profile_link_color;
                    this.profile_sidebar_border_color = profile_sidebar_border_color;
                    this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                    this.profile_text_color = profile_text_color;
                    this.profile_use_background_image = profile_use_background_image;
                    this.profile_image_url = profile_image_url;
                    this.profile_image_url_https = profile_image_url_https;
                    this.profile_banner_url = profile_banner_url;
                    this.default_profile = default_profile;
                    this.default_profile_image = default_profile_image;
                    this.following = following;
                    this.follow_request_sent = follow_request_sent;
                    this.notifications = notifications;
                }
        
                /**
                 * The Class Utc_offset.
                 */
                public static   class Utc_offset {
            
                    /**
                     * Instantiates a new utc offset.
                     */
                    public Utc_offset(){
                    }
                }
        
                /**
                 * The Class Time_zone.
                 */
                public static   class Time_zone {
            
                    /**
                     * Instantiates a new time zone.
                     */
                    public Time_zone(){
                    }
                }
        
                /**
                 * The Class Following.
                 */
                public static   class Following {
            
                    /**
                     * Instantiates a new following.
                     */
                    public Following(){
                    }
                }
        
                /**
                 * The Class Follow_request_sent.
                 */
                public static   class Follow_request_sent {
            
                    /**
                     * Instantiates a new follow request sent.
                     */
                    public Follow_request_sent(){
                    }
                }
        
                /**
                 * The Class Notifications.
                 */
                public static   class Notifications {
            
                    /**
                     * Instantiates a new notifications.
                     */
                    public Notifications(){
                    }
                }
            }
    
            /**
             * The Class Geo.
             */
            public static   class Geo {
        
                /**
                 * Instantiates a new geo.
                 */
                public Geo(){
                }
            }
    
            /**
             * The Class Coordinates.
             */
            public static   class Coordinates {
        
                /**
                 * Instantiates a new coordinates.
                 */
                public Coordinates(){
                }
            }
    
            /**
             * The Class Place.
             */
            public static   class Place {
        
                /**
                 * Instantiates a new place.
                 */
                public Place(){
                }
            }
    
            /**
             * The Class Contributors.
             */
            public static   class Contributors {
        
                /**
                 * Instantiates a new contributors.
                 */
                public Contributors(){
                }
            }
    
            /**
             * The Class Extended_tweet.
             */
            public static   class Extended_tweet {
                
                /** The full text. */
                public   String full_text;
                
                /**
                 * Gets the full text.
                 *
                 * @return the full text
                 */
                public String getFull_text() {
					return full_text;
				}

				/**
				 * Sets the full text.
				 *
				 * @param full_text the new full text
				 */
				public void setFull_text(String full_text) {
					this.full_text = full_text;
				}

				/**
				 * Gets the display text range.
				 *
				 * @return the display text range
				 */
				public int[] getDisplay_text_range() {
					return display_text_range;
				}

				/**
				 * Sets the display text range.
				 *
				 * @param display_text_range the new display text range
				 */
				public void setDisplay_text_range(int[] display_text_range) {
					this.display_text_range = display_text_range;
				}

				/**
				 * Gets the entities.
				 *
				 * @return the entities
				 */
				public Entities getEntities() {
					return entities;
				}

				/**
				 * Sets the entities.
				 *
				 * @param entities the new entities
				 */
				public void setEntities(Entities entities) {
					this.entities = entities;
				}

				/** The display text range. */
				public   int[] display_text_range;
                
                /** The entities. */
                public   Entities entities;
        
                /**
                 * Instantiates a new extended tweet.
                 *
                 * @param full_text the full text
                 * @param display_text_range the display text range
                 * @param entities the entities
                 */
                public Extended_tweet(String full_text, int[] display_text_range, Entities entities){
                    this.full_text = full_text;
                    this.display_text_range = display_text_range;
                    this.entities = entities;
                }
        
                /**
                 * The Class Entities.
                 */
                public static   class Entities {
                    
                    /** The hashtags. */
                    public   Hashtag hashtags[];
                    
                    /**
                     * Gets the hashtags.
                     *
                     * @return the hashtags
                     */
                    public Hashtag[] getHashtags() {
						return hashtags;
					}

					/**
					 * Sets the hashtags.
					 *
					 * @param hashtags the new hashtags
					 */
					public void setHashtags(Hashtag[] hashtags) {
						this.hashtags = hashtags;
					}

					/**
					 * Gets the urls.
					 *
					 * @return the urls
					 */
					public Url[] getUrls() {
						return urls;
					}

					/**
					 * Sets the urls.
					 *
					 * @param urls the new urls
					 */
					public void setUrls(Url[] urls) {
						this.urls = urls;
					}

					/**
					 * Gets the user mentions.
					 *
					 * @return the user mentions
					 */
					public User_mention[] getUser_mentions() {
						return user_mentions;
					}

					/**
					 * Sets the user mentions.
					 *
					 * @param user_mentions the new user mentions
					 */
					public void setUser_mentions(User_mention[] user_mentions) {
						this.user_mentions = user_mentions;
					}

					/**
					 * Gets the symbols.
					 *
					 * @return the symbols
					 */
					public Symbol[] getSymbols() {
						return symbols;
					}

					/**
					 * Sets the symbols.
					 *
					 * @param symbols the new symbols
					 */
					public void setSymbols(Symbol[] symbols) {
						this.symbols = symbols;
					}

					/** The urls. */
					public   Url urls[];
                    
                    /** The user mentions. */
                    public   User_mention user_mentions[];
                    
                    /** The symbols. */
                    public   Symbol symbols[];
            
                    /**
                     * Instantiates a new entities.
                     *
                     * @param hashtags the hashtags
                     * @param urls the urls
                     * @param user_mentions the user mentions
                     * @param symbols the symbols
                     */
                    public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                        this.hashtags = hashtags;
                        this.urls = urls;
                        this.user_mentions = user_mentions;
                        this.symbols = symbols;
                    }
            
                    /**
                     * The Class Hashtag.
                     */
                    public static   class Hashtag {
                        
                        /** The text. */
                        public   String text;
                        
                        /**
                         * Gets the text.
                         *
                         * @return the text
                         */
                        public String getText() {
							return text;
						}

						/**
						 * Sets the text.
						 *
						 * @param text the new text
						 */
						public void setText(String text) {
							this.text = text;
						}

						/**
						 * Gets the indices.
						 *
						 * @return the indices
						 */
						public int[] getIndices() {
							return indices;
						}

						/**
						 * Sets the indices.
						 *
						 * @param indices the new indices
						 */
						public void setIndices(int[] indices) {
							this.indices = indices;
						}

						/** The indices. */
						public   int[] indices;
                
                        /**
                         * Instantiates a new hashtag.
                         *
                         * @param text the text
                         * @param indices the indices
                         */
                        public Hashtag(String text, int[] indices){
                            this.text = text;
                            this.indices = indices;
                        }
                    }
            
                    /**
                     * The Class Url.
                     */
                    public static   class Url {
                        
                        /** The url. */
                        public   String url;
                        
                        /**
                         * Gets the url.
                         *
                         * @return the url
                         */
                        public String getUrl() {
							return url;
						}

						/**
						 * Sets the url.
						 *
						 * @param url the new url
						 */
						public void setUrl(String url) {
							this.url = url;
						}

						/**
						 * Gets the expanded url.
						 *
						 * @return the expanded url
						 */
						public String getExpanded_url() {
							return expanded_url;
						}

						/**
						 * Sets the expanded url.
						 *
						 * @param expanded_url the new expanded url
						 */
						public void setExpanded_url(String expanded_url) {
							this.expanded_url = expanded_url;
						}

						/**
						 * Gets the display url.
						 *
						 * @return the display url
						 */
						public String getDisplay_url() {
							return display_url;
						}

						/**
						 * Sets the display url.
						 *
						 * @param display_url the new display url
						 */
						public void setDisplay_url(String display_url) {
							this.display_url = display_url;
						}

						/**
						 * Gets the indices.
						 *
						 * @return the indices
						 */
						public int[] getIndices() {
							return indices;
						}

						/**
						 * Sets the indices.
						 *
						 * @param indices the new indices
						 */
						public void setIndices(int[] indices) {
							this.indices = indices;
						}

						/** The expanded url. */
						public   String expanded_url;
                        
                        /** The display url. */
                        public   String display_url;
                        
                        /** The indices. */
                        public   int[] indices;
                
                        /**
                         * Instantiates a new url.
                         *
                         * @param url the url
                         * @param expanded_url the expanded url
                         * @param display_url the display url
                         * @param indices the indices
                         */
                        public Url(String url, String expanded_url, String display_url, int[] indices){
                            this.url = url;
                            this.expanded_url = expanded_url;
                            this.display_url = display_url;
                            this.indices = indices;
                        }
                    }
            
                    /**
                     * The Class User_mention.
                     */
                    public static   class User_mention {
                        
                        /** The screen name. */
                        public   String screen_name;
                        
                        /**
                         * Gets the screen name.
                         *
                         * @return the screen name
                         */
                        public String getScreen_name() {
							return screen_name;
						}

						/**
						 * Sets the screen name.
						 *
						 * @param screen_name the new screen name
						 */
						public void setScreen_name(String screen_name) {
							this.screen_name = screen_name;
						}

						/**
						 * Gets the name.
						 *
						 * @return the name
						 */
						public String getName() {
							return name;
						}

						/**
						 * Sets the name.
						 *
						 * @param name the new name
						 */
						public void setName(String name) {
							this.name = name;
						}

						/**
						 * Gets the id.
						 *
						 * @return the id
						 */
						public long getId() {
							return id;
						}

						/**
						 * Sets the id.
						 *
						 * @param id the new id
						 */
						public void setId(long id) {
							this.id = id;
						}

						/**
						 * Gets the id str.
						 *
						 * @return the id str
						 */
						public String getId_str() {
							return id_str;
						}

						/**
						 * Sets the id str.
						 *
						 * @param id_str the new id str
						 */
						public void setId_str(String id_str) {
							this.id_str = id_str;
						}

						/**
						 * Gets the indices.
						 *
						 * @return the indices
						 */
						public int[] getIndices() {
							return indices;
						}

						/**
						 * Sets the indices.
						 *
						 * @param indices the new indices
						 */
						public void setIndices(int[] indices) {
							this.indices = indices;
						}

						/** The name. */
						public   String name;
                        
                        /** The id. */
                        public   long id;
                        
                        /** The id str. */
                        public   String id_str;
                        
                        /** The indices. */
                        public   int[] indices;
                
                        /**
                         * Instantiates a new user mention.
                         *
                         * @param screen_name the screen name
                         * @param name the name
                         * @param id the id
                         * @param id_str the id str
                         * @param indices the indices
                         */
                        public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                            this.screen_name = screen_name;
                            this.name = name;
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                        }
                    }
            
                    /**
                     * The Class Symbol.
                     */
                    public static   class Symbol {
                
                        /**
                         * Instantiates a new symbol.
                         */
                        public Symbol(){
                        }
                    }
                }
            }
    
            /**
             * The Class Entities.
             */
            public static   class Entities {
                
                /** The hashtags. */
                public   Hashtag hashtags[];
                
                /** The urls. */
                public   Url urls[];
                
                /**
                 * Gets the hashtags.
                 *
                 * @return the hashtags
                 */
                public Hashtag[] getHashtags() {
					return hashtags;
				}

				/**
				 * Sets the hashtags.
				 *
				 * @param hashtags the new hashtags
				 */
				public void setHashtags(Hashtag[] hashtags) {
					this.hashtags = hashtags;
				}

				/**
				 * Gets the urls.
				 *
				 * @return the urls
				 */
				public Url[] getUrls() {
					return urls;
				}

				/**
				 * Sets the urls.
				 *
				 * @param urls the new urls
				 */
				public void setUrls(Url[] urls) {
					this.urls = urls;
				}

				/**
				 * Gets the user mentions.
				 *
				 * @return the user mentions
				 */
				public User_mention[] getUser_mentions() {
					return user_mentions;
				}

				/**
				 * Sets the user mentions.
				 *
				 * @param user_mentions the new user mentions
				 */
				public void setUser_mentions(User_mention[] user_mentions) {
					this.user_mentions = user_mentions;
				}

				/**
				 * Gets the symbols.
				 *
				 * @return the symbols
				 */
				public Symbol[] getSymbols() {
					return symbols;
				}

				/**
				 * Sets the symbols.
				 *
				 * @param symbols the new symbols
				 */
				public void setSymbols(Symbol[] symbols) {
					this.symbols = symbols;
				}

				/** The user mentions. */
				public   User_mention user_mentions[];
                
                /** The symbols. */
                public   Symbol symbols[];
        
                /**
                 * Instantiates a new entities.
                 *
                 * @param hashtags the hashtags
                 * @param urls the urls
                 * @param user_mentions the user mentions
                 * @param symbols the symbols
                 */
                public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                    this.hashtags = hashtags;
                    this.urls = urls;
                    this.user_mentions = user_mentions;
                    this.symbols = symbols;
                }
        
                /**
                 * The Class Hashtag.
                 */
                public static   class Hashtag {
            
                    /**
                     * Instantiates a new hashtag.
                     */
                    public Hashtag(){
                    }
                }
        
                /**
                 * The Class Url.
                 */
                public static   class Url {
                    
                    /** The url. */
                    public   String url;
                    
                    /** The expanded url. */
                    public   String expanded_url;
                    
                    /** The display url. */
                    public   String display_url;
                    
                    /** The indices. */
                    public   int[] indices;
            
                    /**
                     * Instantiates a new url.
                     *
                     * @param url the url
                     * @param expanded_url the expanded url
                     * @param display_url the display url
                     * @param indices the indices
                     */
                    public Url(String url, String expanded_url, String display_url, int[] indices){
                        this.url = url;
                        this.expanded_url = expanded_url;
                        this.display_url = display_url;
                        this.indices = indices;
                    }
                }
        
                /**
                 * The Class User_mention.
                 */
                public static   class User_mention {
                    
                    /** The screen name. */
                    public   String screen_name;
                    
                    /** The name. */
                    public   String name;
                    
                    /** The id. */
                    public   long id;
                    
                    /** The id str. */
                    public   String id_str;
                    
                    /** The indices. */
                    public   int[] indices;
            
                    /**
                     * Instantiates a new user mention.
                     *
                     * @param screen_name the screen name
                     * @param name the name
                     * @param id the id
                     * @param id_str the id str
                     * @param indices the indices
                     */
                    public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                        this.screen_name = screen_name;
                        this.name = name;
                        this.id = id;
                        this.id_str = id_str;
                        this.indices = indices;
                    }
                }
        
                /**
                 * The Class Symbol.
                 */
                public static   class Symbol {
            
                    /**
                     * Instantiates a new symbol.
                     */
                    public Symbol(){
                    }
                }
            }
        }

        /**
         * The Class User.
         */
        public static   class User {
            
            /** The id. */
            public   long id;
            
            /** The id str. */
            public   String id_str;
            
            /**
             * Gets the id.
             *
             * @return the id
             */
            public long getId() {
				return id;
			}

			/**
			 * Sets the id.
			 *
			 * @param id the new id
			 */
			public void setId(long id) {
				this.id = id;
			}

			/**
			 * Gets the id str.
			 *
			 * @return the id str
			 */
			public String getId_str() {
				return id_str;
			}

			/**
			 * Sets the id str.
			 *
			 * @param id_str the new id str
			 */
			public void setId_str(String id_str) {
				this.id_str = id_str;
			}

			/**
			 * Gets the name.
			 *
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/**
			 * Sets the name.
			 *
			 * @param name the new name
			 */
			public void setName(String name) {
				this.name = name;
			}

			/**
			 * Gets the screen name.
			 *
			 * @return the screen name
			 */
			public String getScreen_name() {
				return screen_name;
			}

			/**
			 * Sets the screen name.
			 *
			 * @param screen_name the new screen name
			 */
			public void setScreen_name(String screen_name) {
				this.screen_name = screen_name;
			}

			/**
			 * Gets the location.
			 *
			 * @return the location
			 */
			public String getLocation() {
				return location;
			}

			/**
			 * Sets the location.
			 *
			 * @param location the new location
			 */
			public void setLocation(String location) {
				this.location = location;
			}

			/**
			 * Gets the url.
			 *
			 * @return the url
			 */
			public String getUrl() {
				return url;
			}

			/**
			 * Sets the url.
			 *
			 * @param url the new url
			 */
			public void setUrl(String url) {
				this.url = url;
			}

			/**
			 * Gets the description.
			 *
			 * @return the description
			 */
			public String getDescription() {
				return description;
			}

			/**
			 * Sets the description.
			 *
			 * @param description the new description
			 */
			public void setDescription(String description) {
				this.description = description;
			}

			/**
			 * Gets the translator type.
			 *
			 * @return the translator type
			 */
			public String getTranslator_type() {
				return translator_type;
			}

			/**
			 * Sets the translator type.
			 *
			 * @param translator_type the new translator type
			 */
			public void setTranslator_type(String translator_type) {
				this.translator_type = translator_type;
			}

			/**
			 * Checks if is protected.
			 *
			 * @return true, if is protected
			 */
			public boolean is_protected() {
				return _protected;
			}

			/**
			 * Sets the protected.
			 *
			 * @param _protected the new protected
			 */
			public void set_protected(boolean _protected) {
				this._protected = _protected;
			}

			/**
			 * Checks if is verified.
			 *
			 * @return true, if is verified
			 */
			public boolean isVerified() {
				return verified;
			}

			/**
			 * Sets the verified.
			 *
			 * @param verified the new verified
			 */
			public void setVerified(boolean verified) {
				this.verified = verified;
			}

			/**
			 * Gets the followers count.
			 *
			 * @return the followers count
			 */
			public long getFollowers_count() {
				return followers_count;
			}

			/**
			 * Sets the followers count.
			 *
			 * @param followers_count the new followers count
			 */
			public void setFollowers_count(long followers_count) {
				this.followers_count = followers_count;
			}

			/**
			 * Gets the friends count.
			 *
			 * @return the friends count
			 */
			public long getFriends_count() {
				return friends_count;
			}

			/**
			 * Sets the friends count.
			 *
			 * @param friends_count the new friends count
			 */
			public void setFriends_count(long friends_count) {
				this.friends_count = friends_count;
			}

			/**
			 * Gets the listed count.
			 *
			 * @return the listed count
			 */
			public long getListed_count() {
				return listed_count;
			}

			/**
			 * Sets the listed count.
			 *
			 * @param listed_count the new listed count
			 */
			public void setListed_count(long listed_count) {
				this.listed_count = listed_count;
			}

			/**
			 * Gets the favourites count.
			 *
			 * @return the favourites count
			 */
			public long getFavourites_count() {
				return favourites_count;
			}

			/**
			 * Sets the favourites count.
			 *
			 * @param favourites_count the new favourites count
			 */
			public void setFavourites_count(long favourites_count) {
				this.favourites_count = favourites_count;
			}

			/**
			 * Gets the statuses count.
			 *
			 * @return the statuses count
			 */
			public long getStatuses_count() {
				return statuses_count;
			}

			/**
			 * Sets the statuses count.
			 *
			 * @param statuses_count the new statuses count
			 */
			public void setStatuses_count(long statuses_count) {
				this.statuses_count = statuses_count;
			}

			/**
			 * Gets the created at.
			 *
			 * @return the created at
			 */
			public String getCreated_at() {
				return created_at;
			}

			/**
			 * Sets the created at.
			 *
			 * @param created_at the new created at
			 */
			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			/**
			 * Gets the utc offset.
			 *
			 * @return the utc offset
			 */
			public Utc_offset getUtc_offset() {
				return utc_offset;
			}

			/**
			 * Sets the utc offset.
			 *
			 * @param utc_offset the new utc offset
			 */
			public void setUtc_offset(Utc_offset utc_offset) {
				this.utc_offset = utc_offset;
			}

			/**
			 * Gets the time zone.
			 *
			 * @return the time zone
			 */
			public Time_zone getTime_zone() {
				return time_zone;
			}

			/**
			 * Sets the time zone.
			 *
			 * @param time_zone the new time zone
			 */
			public void setTime_zone(Time_zone time_zone) {
				this.time_zone = time_zone;
			}

			/**
			 * Checks if is geo enabled.
			 *
			 * @return true, if is geo enabled
			 */
			public boolean isGeo_enabled() {
				return geo_enabled;
			}

			/**
			 * Sets the geo enabled.
			 *
			 * @param geo_enabled the new geo enabled
			 */
			public void setGeo_enabled(boolean geo_enabled) {
				this.geo_enabled = geo_enabled;
			}

			/**
			 * Gets the lang.
			 *
			 * @return the lang
			 */
			public String getLang() {
				return lang;
			}

			/**
			 * Sets the lang.
			 *
			 * @param lang the new lang
			 */
			public void setLang(String lang) {
				this.lang = lang;
			}

			/**
			 * Checks if is contributors enabled.
			 *
			 * @return true, if is contributors enabled
			 */
			public boolean isContributors_enabled() {
				return contributors_enabled;
			}

			/**
			 * Sets the contributors enabled.
			 *
			 * @param contributors_enabled the new contributors enabled
			 */
			public void setContributors_enabled(boolean contributors_enabled) {
				this.contributors_enabled = contributors_enabled;
			}

			/**
			 * Checks if is checks if is translator.
			 *
			 * @return true, if is checks if is translator
			 */
			public boolean isIs_translator() {
				return is_translator;
			}

			/**
			 * Sets the checks if is translator.
			 *
			 * @param is_translator the new checks if is translator
			 */
			public void setIs_translator(boolean is_translator) {
				this.is_translator = is_translator;
			}

			/**
			 * Gets the profile background color.
			 *
			 * @return the profile background color
			 */
			public String getProfile_background_color() {
				return profile_background_color;
			}

			/**
			 * Sets the profile background color.
			 *
			 * @param profile_background_color the new profile background color
			 */
			public void setProfile_background_color(String profile_background_color) {
				this.profile_background_color = profile_background_color;
			}

			/**
			 * Gets the profile background image url.
			 *
			 * @return the profile background image url
			 */
			public String getProfile_background_image_url() {
				return profile_background_image_url;
			}

			/**
			 * Sets the profile background image url.
			 *
			 * @param profile_background_image_url the new profile background image url
			 */
			public void setProfile_background_image_url(String profile_background_image_url) {
				this.profile_background_image_url = profile_background_image_url;
			}

			/**
			 * Gets the profile background image url https.
			 *
			 * @return the profile background image url https
			 */
			public String getProfile_background_image_url_https() {
				return profile_background_image_url_https;
			}

			/**
			 * Sets the profile background image url https.
			 *
			 * @param profile_background_image_url_https the new profile background image url https
			 */
			public void setProfile_background_image_url_https(String profile_background_image_url_https) {
				this.profile_background_image_url_https = profile_background_image_url_https;
			}

			/**
			 * Checks if is profile background tile.
			 *
			 * @return true, if is profile background tile
			 */
			public boolean isProfile_background_tile() {
				return profile_background_tile;
			}

			/**
			 * Sets the profile background tile.
			 *
			 * @param profile_background_tile the new profile background tile
			 */
			public void setProfile_background_tile(boolean profile_background_tile) {
				this.profile_background_tile = profile_background_tile;
			}

			/**
			 * Gets the profile link color.
			 *
			 * @return the profile link color
			 */
			public String getProfile_link_color() {
				return profile_link_color;
			}

			/**
			 * Sets the profile link color.
			 *
			 * @param profile_link_color the new profile link color
			 */
			public void setProfile_link_color(String profile_link_color) {
				this.profile_link_color = profile_link_color;
			}

			/**
			 * Gets the profile sidebar border color.
			 *
			 * @return the profile sidebar border color
			 */
			public String getProfile_sidebar_border_color() {
				return profile_sidebar_border_color;
			}

			/**
			 * Sets the profile sidebar border color.
			 *
			 * @param profile_sidebar_border_color the new profile sidebar border color
			 */
			public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
				this.profile_sidebar_border_color = profile_sidebar_border_color;
			}

			/**
			 * Gets the profile sidebar fill color.
			 *
			 * @return the profile sidebar fill color
			 */
			public String getProfile_sidebar_fill_color() {
				return profile_sidebar_fill_color;
			}

			/**
			 * Sets the profile sidebar fill color.
			 *
			 * @param profile_sidebar_fill_color the new profile sidebar fill color
			 */
			public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
				this.profile_sidebar_fill_color = profile_sidebar_fill_color;
			}

			/**
			 * Gets the profile text color.
			 *
			 * @return the profile text color
			 */
			public String getProfile_text_color() {
				return profile_text_color;
			}

			/**
			 * Sets the profile text color.
			 *
			 * @param profile_text_color the new profile text color
			 */
			public void setProfile_text_color(String profile_text_color) {
				this.profile_text_color = profile_text_color;
			}

			/**
			 * Checks if is profile use background image.
			 *
			 * @return true, if is profile use background image
			 */
			public boolean isProfile_use_background_image() {
				return profile_use_background_image;
			}

			/**
			 * Sets the profile use background image.
			 *
			 * @param profile_use_background_image the new profile use background image
			 */
			public void setProfile_use_background_image(boolean profile_use_background_image) {
				this.profile_use_background_image = profile_use_background_image;
			}

			/**
			 * Gets the profile image url.
			 *
			 * @return the profile image url
			 */
			public String getProfile_image_url() {
				return profile_image_url;
			}

			/**
			 * Sets the profile image url.
			 *
			 * @param profile_image_url the new profile image url
			 */
			public void setProfile_image_url(String profile_image_url) {
				this.profile_image_url = profile_image_url;
			}

			/**
			 * Gets the profile image url https.
			 *
			 * @return the profile image url https
			 */
			public String getProfile_image_url_https() {
				return profile_image_url_https;
			}

			/**
			 * Sets the profile image url https.
			 *
			 * @param profile_image_url_https the new profile image url https
			 */
			public void setProfile_image_url_https(String profile_image_url_https) {
				this.profile_image_url_https = profile_image_url_https;
			}

			/**
			 * Gets the profile banner url.
			 *
			 * @return the profile banner url
			 */
			public String getProfile_banner_url() {
				return profile_banner_url;
			}

			/**
			 * Sets the profile banner url.
			 *
			 * @param profile_banner_url the new profile banner url
			 */
			public void setProfile_banner_url(String profile_banner_url) {
				this.profile_banner_url = profile_banner_url;
			}

			/**
			 * Checks if is default profile.
			 *
			 * @return true, if is default profile
			 */
			public boolean isDefault_profile() {
				return default_profile;
			}

			/**
			 * Sets the default profile.
			 *
			 * @param default_profile the new default profile
			 */
			public void setDefault_profile(boolean default_profile) {
				this.default_profile = default_profile;
			}

			/**
			 * Checks if is default profile image.
			 *
			 * @return true, if is default profile image
			 */
			public boolean isDefault_profile_image() {
				return default_profile_image;
			}

			/**
			 * Sets the default profile image.
			 *
			 * @param default_profile_image the new default profile image
			 */
			public void setDefault_profile_image(boolean default_profile_image) {
				this.default_profile_image = default_profile_image;
			}

			/**
			 * Gets the following.
			 *
			 * @return the following
			 */
			public Following getFollowing() {
				return following;
			}

			/**
			 * Sets the following.
			 *
			 * @param following the new following
			 */
			public void setFollowing(Following following) {
				this.following = following;
			}

			/**
			 * Gets the follow request sent.
			 *
			 * @return the follow request sent
			 */
			public Follow_request_sent getFollow_request_sent() {
				return follow_request_sent;
			}

			/**
			 * Sets the follow request sent.
			 *
			 * @param follow_request_sent the new follow request sent
			 */
			public void setFollow_request_sent(Follow_request_sent follow_request_sent) {
				this.follow_request_sent = follow_request_sent;
			}

			/**
			 * Gets the notifications.
			 *
			 * @return the notifications
			 */
			public Notifications getNotifications() {
				return notifications;
			}

			/**
			 * Sets the notifications.
			 *
			 * @param notifications the new notifications
			 */
			public void setNotifications(Notifications notifications) {
				this.notifications = notifications;
			}

			/** The name. */
			public   String name;
            
            /** The screen name. */
            public   String screen_name;
            
            /** The location. */
            public   String location;
            
            /** The url. */
            public   String url;
            
            /** The description. */
            public   String description;
            
            /** The translator type. */
            public   String translator_type;
            
            /** The protected. */
            public   boolean _protected;
            
            /** The verified. */
            public   boolean verified;
            
            /** The followers count. */
            public   long followers_count;
            
            /** The friends count. */
            public   long friends_count;
            
            /** The listed count. */
            public   long listed_count;
            
            /** The favourites count. */
            public   long favourites_count;
            
            /** The statuses count. */
            public   long statuses_count;
            
            /** The created at. */
            public   String created_at;
            
            /** The utc offset. */
            public   Utc_offset utc_offset;
            
            /** The time zone. */
            public   Time_zone time_zone;
            
            /** The geo enabled. */
            public   boolean geo_enabled;
            
            /** The lang. */
            public   String lang;
            
            /** The contributors enabled. */
            public   boolean contributors_enabled;
            
            /** The is translator. */
            public   boolean is_translator;
            
            /** The profile background color. */
            public   String profile_background_color;
            
            /** The profile background image url. */
            public   String profile_background_image_url;
            
            /** The profile background image url https. */
            public   String profile_background_image_url_https;
            
            /** The profile background tile. */
            public   boolean profile_background_tile;
            
            /** The profile link color. */
            public   String profile_link_color;
            
            /** The profile sidebar border color. */
            public   String profile_sidebar_border_color;
            
            /** The profile sidebar fill color. */
            public   String profile_sidebar_fill_color;
            
            /** The profile text color. */
            public   String profile_text_color;
            
            /** The profile use background image. */
            public   boolean profile_use_background_image;
            
            /** The profile image url. */
            public   String profile_image_url;
            
            /** The profile image url https. */
            public   String profile_image_url_https;
            
            /** The profile banner url. */
            public   String profile_banner_url;
            
            /** The default profile. */
            public   boolean default_profile;
            
            /** The default profile image. */
            public   boolean default_profile_image;
            
            /** The following. */
            public   Following following;
            
            /** The follow request sent. */
            public   Follow_request_sent follow_request_sent;
            
            /** The notifications. */
            public   Notifications notifications;
    
            /**
             * Instantiates a new user.
             *
             * @param id the id
             * @param id_str the id str
             * @param name the name
             * @param screen_name the screen name
             * @param location the location
             * @param url the url
             * @param description the description
             * @param translator_type the translator type
             * @param _protected the protected
             * @param verified the verified
             * @param followers_count the followers count
             * @param friends_count the friends count
             * @param listed_count the listed count
             * @param favourites_count the favourites count
             * @param statuses_count the statuses count
             * @param created_at the created at
             * @param utc_offset the utc offset
             * @param time_zone the time zone
             * @param geo_enabled the geo enabled
             * @param lang the lang
             * @param contributors_enabled the contributors enabled
             * @param is_translator the is translator
             * @param profile_background_color the profile background color
             * @param profile_background_image_url the profile background image url
             * @param profile_background_image_url_https the profile background image url https
             * @param profile_background_tile the profile background tile
             * @param profile_link_color the profile link color
             * @param profile_sidebar_border_color the profile sidebar border color
             * @param profile_sidebar_fill_color the profile sidebar fill color
             * @param profile_text_color the profile text color
             * @param profile_use_background_image the profile use background image
             * @param profile_image_url the profile image url
             * @param profile_image_url_https the profile image url https
             * @param profile_banner_url the profile banner url
             * @param default_profile the default profile
             * @param default_profile_image the default profile image
             * @param following the following
             * @param follow_request_sent the follow request sent
             * @param notifications the notifications
             */
            public User(long id, String id_str, String name, String screen_name, String location, String url, String description, String translator_type, boolean _protected, boolean verified, long followers_count, long friends_count, long listed_count, long favourites_count, long statuses_count, String created_at, Utc_offset utc_offset, Time_zone time_zone, boolean geo_enabled, String lang, boolean contributors_enabled, boolean is_translator, String profile_background_color, String profile_background_image_url, String profile_background_image_url_https, boolean profile_background_tile, String profile_link_color, String profile_sidebar_border_color, String profile_sidebar_fill_color, String profile_text_color, boolean profile_use_background_image, String profile_image_url, String profile_image_url_https, String profile_banner_url, boolean default_profile, boolean default_profile_image, Following following, Follow_request_sent follow_request_sent, Notifications notifications){
                this.id = id;
                this.id_str = id_str;
                this.name = name;
                this.screen_name = screen_name;
                this.location = location;
                this.url = url;
                this.description = description;
                this.translator_type = translator_type;
                this._protected = _protected;
                this.verified = verified;
                this.followers_count = followers_count;
                this.friends_count = friends_count;
                this.listed_count = listed_count;
                this.favourites_count = favourites_count;
                this.statuses_count = statuses_count;
                this.created_at = created_at;
                this.utc_offset = utc_offset;
                this.time_zone = time_zone;
                this.geo_enabled = geo_enabled;
                this.lang = lang;
                this.contributors_enabled = contributors_enabled;
                this.is_translator = is_translator;
                this.profile_background_color = profile_background_color;
                this.profile_background_image_url = profile_background_image_url;
                this.profile_background_image_url_https = profile_background_image_url_https;
                this.profile_background_tile = profile_background_tile;
                this.profile_link_color = profile_link_color;
                this.profile_sidebar_border_color = profile_sidebar_border_color;
                this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                this.profile_text_color = profile_text_color;
                this.profile_use_background_image = profile_use_background_image;
                this.profile_image_url = profile_image_url;
                this.profile_image_url_https = profile_image_url_https;
                this.profile_banner_url = profile_banner_url;
                this.default_profile = default_profile;
                this.default_profile_image = default_profile_image;
                this.following = following;
                this.follow_request_sent = follow_request_sent;
                this.notifications = notifications;
            }
    
            /**
             * The Class Utc_offset.
             */
            public static   class Utc_offset {
        
                /**
                 * Instantiates a new utc offset.
                 */
                public Utc_offset(){
                }
            }
    
            /**
             * The Class Time_zone.
             */
            public static   class Time_zone {
        
                /**
                 * Instantiates a new time zone.
                 */
                public Time_zone(){
                }
            }
    
            /**
             * The Class Following.
             */
            public static   class Following {
        
                /**
                 * Instantiates a new following.
                 */
                public Following(){
                }
            }
    
            /**
             * The Class Follow_request_sent.
             */
            public static   class Follow_request_sent {
        
                /**
                 * Instantiates a new follow request sent.
                 */
                public Follow_request_sent(){
                }
            }
    
            /**
             * The Class Notifications.
             */
            public static   class Notifications {
        
                /**
                 * Instantiates a new notifications.
                 */
                public Notifications(){
                }
            }
        }
    }
}
