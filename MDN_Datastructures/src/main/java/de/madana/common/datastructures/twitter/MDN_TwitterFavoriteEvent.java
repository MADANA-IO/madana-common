package de.madana.common.datastructures.twitter;
public  class MDN_TwitterFavoriteEvent {
    public   String for_user_id;
    public   Favorite_event favorite_events[];

    public MDN_TwitterFavoriteEvent(String for_user_id, Favorite_event[] favorite_events){
        this.for_user_id = for_user_id;
        this.favorite_events = favorite_events;
    }

    public String getFor_user_id() {
		return for_user_id;
	}

	public void setFor_user_id(String for_user_id) {
		this.for_user_id = for_user_id;
	}

	public Favorite_event[] getFavorite_events() {
		return favorite_events;
	}

	public void setFavorite_events(Favorite_event[] favorite_events) {
		this.favorite_events = favorite_events;
	}

	public MDN_TwitterFavoriteEvent() {
		// TODO Auto-generated constructor stub
	}

	public static   class Favorite_event {
        public   String id;
        public   String created_at;
        public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCreated_at() {
			return created_at;
		}

		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}

		public long getTimestamp_ms() {
			return timestamp_ms;
		}

		public void setTimestamp_ms(long timestamp_ms) {
			this.timestamp_ms = timestamp_ms;
		}

		public Favorited_status getFavorited_status() {
			return favorited_status;
		}

		public void setFavorited_status(Favorited_status favorited_status) {
			this.favorited_status = favorited_status;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public   long timestamp_ms;
        public   Favorited_status favorited_status;
        public   User user;

        public Favorite_event(String id, String created_at, long timestamp_ms, Favorited_status favorited_status, User user){
            this.id = id;
            this.created_at = created_at;
            this.timestamp_ms = timestamp_ms;
            this.favorited_status = favorited_status;
            this.user = user;
        }

        public static   class Favorited_status {
            public   String created_at;
            public   long id;
            public String getCreated_at() {
				return created_at;
			}

			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getId_str() {
				return id_str;
			}

			public void setId_str(String id_str) {
				this.id_str = id_str;
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getSource() {
				return source;
			}

			public void setSource(String source) {
				this.source = source;
			}

			public boolean isTruncated() {
				return truncated;
			}

			public void setTruncated(boolean truncated) {
				this.truncated = truncated;
			}

			public In_reply_to_status_id getIn_reply_to_status_id() {
				return in_reply_to_status_id;
			}

			public void setIn_reply_to_status_id(In_reply_to_status_id in_reply_to_status_id) {
				this.in_reply_to_status_id = in_reply_to_status_id;
			}

			public In_reply_to_status_id_str getIn_reply_to_status_id_str() {
				return in_reply_to_status_id_str;
			}

			public void setIn_reply_to_status_id_str(In_reply_to_status_id_str in_reply_to_status_id_str) {
				this.in_reply_to_status_id_str = in_reply_to_status_id_str;
			}

			public In_reply_to_user_id getIn_reply_to_user_id() {
				return in_reply_to_user_id;
			}

			public void setIn_reply_to_user_id(In_reply_to_user_id in_reply_to_user_id) {
				this.in_reply_to_user_id = in_reply_to_user_id;
			}

			public In_reply_to_user_id_str getIn_reply_to_user_id_str() {
				return in_reply_to_user_id_str;
			}

			public void setIn_reply_to_user_id_str(In_reply_to_user_id_str in_reply_to_user_id_str) {
				this.in_reply_to_user_id_str = in_reply_to_user_id_str;
			}

			public In_reply_to_screen_name getIn_reply_to_screen_name() {
				return in_reply_to_screen_name;
			}

			public void setIn_reply_to_screen_name(In_reply_to_screen_name in_reply_to_screen_name) {
				this.in_reply_to_screen_name = in_reply_to_screen_name;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public Geo getGeo() {
				return geo;
			}

			public void setGeo(Geo geo) {
				this.geo = geo;
			}

			public Coordinates getCoordinates() {
				return coordinates;
			}

			public void setCoordinates(Coordinates coordinates) {
				this.coordinates = coordinates;
			}

			public Place getPlace() {
				return place;
			}

			public void setPlace(Place place) {
				this.place = place;
			}

			public Contributors getContributors() {
				return contributors;
			}

			public void setContributors(Contributors contributors) {
				this.contributors = contributors;
			}

			public boolean isIs_quote_status() {
				return is_quote_status;
			}

			public void setIs_quote_status(boolean is_quote_status) {
				this.is_quote_status = is_quote_status;
			}

			public Extended_tweet getExtended_tweet() {
				return extended_tweet;
			}

			public void setExtended_tweet(Extended_tweet extended_tweet) {
				this.extended_tweet = extended_tweet;
			}

			public long getQuote_count() {
				return quote_count;
			}

			public void setQuote_count(long quote_count) {
				this.quote_count = quote_count;
			}

			public long getReply_count() {
				return reply_count;
			}

			public void setReply_count(long reply_count) {
				this.reply_count = reply_count;
			}

			public long getRetweet_count() {
				return retweet_count;
			}

			public void setRetweet_count(long retweet_count) {
				this.retweet_count = retweet_count;
			}

			public long getFavorite_count() {
				return favorite_count;
			}

			public void setFavorite_count(long favorite_count) {
				this.favorite_count = favorite_count;
			}

			public Entities getEntities() {
				return entities;
			}

			public void setEntities(Entities entities) {
				this.entities = entities;
			}

			public boolean isFavorited() {
				return favorited;
			}

			public void setFavorited(boolean favorited) {
				this.favorited = favorited;
			}

			public boolean isRetweeted() {
				return retweeted;
			}

			public void setRetweeted(boolean retweeted) {
				this.retweeted = retweeted;
			}

			public boolean isPossibly_sensitive() {
				return possibly_sensitive;
			}

			public void setPossibly_sensitive(boolean possibly_sensitive) {
				this.possibly_sensitive = possibly_sensitive;
			}

			public String getFilter_level() {
				return filter_level;
			}

			public void setFilter_level(String filter_level) {
				this.filter_level = filter_level;
			}

			public String getLang() {
				return lang;
			}

			public void setLang(String lang) {
				this.lang = lang;
			}

			public   String id_str;
            public   String text;
            public   String source;
            public   boolean truncated;
            public   In_reply_to_status_id in_reply_to_status_id;
            public   In_reply_to_status_id_str in_reply_to_status_id_str;
            public   In_reply_to_user_id in_reply_to_user_id;
            public   In_reply_to_user_id_str in_reply_to_user_id_str;
            public   In_reply_to_screen_name in_reply_to_screen_name;
            public   User user;
            public   Geo geo;
            public   Coordinates coordinates;
            public   Place place;
            public   Contributors contributors;
            public   boolean is_quote_status;
            public   Extended_tweet extended_tweet;
            public   long quote_count;
            public   long reply_count;
            public   long retweet_count;
            public   long favorite_count;
            public   Entities entities;
            public   boolean favorited;
            public   boolean retweeted;
            public   boolean possibly_sensitive;
            public   String filter_level;
            public   String lang;
    
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
    
            public static   class In_reply_to_status_id {
        
                public In_reply_to_status_id(){
                }
            }
    
            public static   class In_reply_to_status_id_str {
        
                public In_reply_to_status_id_str(){
                }
            }
    
            public static   class In_reply_to_user_id {
        
                public In_reply_to_user_id(){
                }
            }
    
            public static   class In_reply_to_user_id_str {
        
                public In_reply_to_user_id_str(){
                }
            }
    
            public static   class In_reply_to_screen_name {
        
                public In_reply_to_screen_name(){
                }
            }
    
            public static   class User {
                public   long id;
                public   String id_str;
                public   String name;
                public long getId() {
					return id;
				}

				public void setId(long id) {
					this.id = id;
				}

				public String getId_str() {
					return id_str;
				}

				public void setId_str(String id_str) {
					this.id_str = id_str;
				}

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}

				public String getScreen_name() {
					return screen_name;
				}

				public void setScreen_name(String screen_name) {
					this.screen_name = screen_name;
				}

				public String getLocation() {
					return location;
				}

				public void setLocation(String location) {
					this.location = location;
				}

				public String getUrl() {
					return url;
				}

				public void setUrl(String url) {
					this.url = url;
				}

				public String getDescription() {
					return description;
				}

				public void setDescription(String description) {
					this.description = description;
				}

				public String getTranslator_type() {
					return translator_type;
				}

				public void setTranslator_type(String translator_type) {
					this.translator_type = translator_type;
				}

				public boolean is_protected() {
					return _protected;
				}

				public void set_protected(boolean _protected) {
					this._protected = _protected;
				}

				public boolean isVerified() {
					return verified;
				}

				public void setVerified(boolean verified) {
					this.verified = verified;
				}

				public long getFollowers_count() {
					return followers_count;
				}

				public void setFollowers_count(long followers_count) {
					this.followers_count = followers_count;
				}

				public long getFriends_count() {
					return friends_count;
				}

				public void setFriends_count(long friends_count) {
					this.friends_count = friends_count;
				}

				public long getListed_count() {
					return listed_count;
				}

				public void setListed_count(long listed_count) {
					this.listed_count = listed_count;
				}

				public long getFavourites_count() {
					return favourites_count;
				}

				public void setFavourites_count(long favourites_count) {
					this.favourites_count = favourites_count;
				}

				public long getStatuses_count() {
					return statuses_count;
				}

				public void setStatuses_count(long statuses_count) {
					this.statuses_count = statuses_count;
				}

				public String getCreated_at() {
					return created_at;
				}

				public void setCreated_at(String created_at) {
					this.created_at = created_at;
				}

				public Utc_offset getUtc_offset() {
					return utc_offset;
				}

				public void setUtc_offset(Utc_offset utc_offset) {
					this.utc_offset = utc_offset;
				}

				public Time_zone getTime_zone() {
					return time_zone;
				}

				public void setTime_zone(Time_zone time_zone) {
					this.time_zone = time_zone;
				}

				public boolean isGeo_enabled() {
					return geo_enabled;
				}

				public void setGeo_enabled(boolean geo_enabled) {
					this.geo_enabled = geo_enabled;
				}

				public String getLang() {
					return lang;
				}

				public void setLang(String lang) {
					this.lang = lang;
				}

				public boolean isContributors_enabled() {
					return contributors_enabled;
				}

				public void setContributors_enabled(boolean contributors_enabled) {
					this.contributors_enabled = contributors_enabled;
				}

				public boolean isIs_translator() {
					return is_translator;
				}

				public void setIs_translator(boolean is_translator) {
					this.is_translator = is_translator;
				}

				public String getProfile_background_color() {
					return profile_background_color;
				}

				public void setProfile_background_color(String profile_background_color) {
					this.profile_background_color = profile_background_color;
				}

				public String getProfile_background_image_url() {
					return profile_background_image_url;
				}

				public void setProfile_background_image_url(String profile_background_image_url) {
					this.profile_background_image_url = profile_background_image_url;
				}

				public String getProfile_background_image_url_https() {
					return profile_background_image_url_https;
				}

				public void setProfile_background_image_url_https(String profile_background_image_url_https) {
					this.profile_background_image_url_https = profile_background_image_url_https;
				}

				public boolean isProfile_background_tile() {
					return profile_background_tile;
				}

				public void setProfile_background_tile(boolean profile_background_tile) {
					this.profile_background_tile = profile_background_tile;
				}

				public String getProfile_link_color() {
					return profile_link_color;
				}

				public void setProfile_link_color(String profile_link_color) {
					this.profile_link_color = profile_link_color;
				}

				public String getProfile_sidebar_border_color() {
					return profile_sidebar_border_color;
				}

				public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
					this.profile_sidebar_border_color = profile_sidebar_border_color;
				}

				public String getProfile_sidebar_fill_color() {
					return profile_sidebar_fill_color;
				}

				public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
					this.profile_sidebar_fill_color = profile_sidebar_fill_color;
				}

				public String getProfile_text_color() {
					return profile_text_color;
				}

				public void setProfile_text_color(String profile_text_color) {
					this.profile_text_color = profile_text_color;
				}

				public boolean isProfile_use_background_image() {
					return profile_use_background_image;
				}

				public void setProfile_use_background_image(boolean profile_use_background_image) {
					this.profile_use_background_image = profile_use_background_image;
				}

				public String getProfile_image_url() {
					return profile_image_url;
				}

				public void setProfile_image_url(String profile_image_url) {
					this.profile_image_url = profile_image_url;
				}

				public String getProfile_image_url_https() {
					return profile_image_url_https;
				}

				public void setProfile_image_url_https(String profile_image_url_https) {
					this.profile_image_url_https = profile_image_url_https;
				}

				public String getProfile_banner_url() {
					return profile_banner_url;
				}

				public void setProfile_banner_url(String profile_banner_url) {
					this.profile_banner_url = profile_banner_url;
				}

				public boolean isDefault_profile() {
					return default_profile;
				}

				public void setDefault_profile(boolean default_profile) {
					this.default_profile = default_profile;
				}

				public boolean isDefault_profile_image() {
					return default_profile_image;
				}

				public void setDefault_profile_image(boolean default_profile_image) {
					this.default_profile_image = default_profile_image;
				}

				public Following getFollowing() {
					return following;
				}

				public void setFollowing(Following following) {
					this.following = following;
				}

				public Follow_request_sent getFollow_request_sent() {
					return follow_request_sent;
				}

				public void setFollow_request_sent(Follow_request_sent follow_request_sent) {
					this.follow_request_sent = follow_request_sent;
				}

				public Notifications getNotifications() {
					return notifications;
				}

				public void setNotifications(Notifications notifications) {
					this.notifications = notifications;
				}

				public   String screen_name;
                public   String location;
                public   String url;
                public   String description;
                public   String translator_type;
                public   boolean _protected;
                public   boolean verified;
                public   long followers_count;
                public   long friends_count;
                public   long listed_count;
                public   long favourites_count;
                public   long statuses_count;
                public   String created_at;
                public   Utc_offset utc_offset;
                public   Time_zone time_zone;
                public   boolean geo_enabled;
                public   String lang;
                public   boolean contributors_enabled;
                public   boolean is_translator;
                public   String profile_background_color;
                public   String profile_background_image_url;
                public   String profile_background_image_url_https;
                public   boolean profile_background_tile;
                public   String profile_link_color;
                public   String profile_sidebar_border_color;
                public   String profile_sidebar_fill_color;
                public   String profile_text_color;
                public   boolean profile_use_background_image;
                public   String profile_image_url;
                public   String profile_image_url_https;
                public   String profile_banner_url;
                public   boolean default_profile;
                public   boolean default_profile_image;
                public   Following following;
                public   Follow_request_sent follow_request_sent;
                public   Notifications notifications;
        
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
        
                public static   class Utc_offset {
            
                    public Utc_offset(){
                    }
                }
        
                public static   class Time_zone {
            
                    public Time_zone(){
                    }
                }
        
                public static   class Following {
            
                    public Following(){
                    }
                }
        
                public static   class Follow_request_sent {
            
                    public Follow_request_sent(){
                    }
                }
        
                public static   class Notifications {
            
                    public Notifications(){
                    }
                }
            }
    
            public static   class Geo {
        
                public Geo(){
                }
            }
    
            public static   class Coordinates {
        
                public Coordinates(){
                }
            }
    
            public static   class Place {
        
                public Place(){
                }
            }
    
            public static   class Contributors {
        
                public Contributors(){
                }
            }
    
            public static   class Extended_tweet {
                public   String full_text;
                public String getFull_text() {
					return full_text;
				}

				public void setFull_text(String full_text) {
					this.full_text = full_text;
				}

				public int[] getDisplay_text_range() {
					return display_text_range;
				}

				public void setDisplay_text_range(int[] display_text_range) {
					this.display_text_range = display_text_range;
				}

				public Entities getEntities() {
					return entities;
				}

				public void setEntities(Entities entities) {
					this.entities = entities;
				}

				public   int[] display_text_range;
                public   Entities entities;
        
                public Extended_tweet(String full_text, int[] display_text_range, Entities entities){
                    this.full_text = full_text;
                    this.display_text_range = display_text_range;
                    this.entities = entities;
                }
        
                public static   class Entities {
                    public   Hashtag hashtags[];
                    public Hashtag[] getHashtags() {
						return hashtags;
					}

					public void setHashtags(Hashtag[] hashtags) {
						this.hashtags = hashtags;
					}

					public Url[] getUrls() {
						return urls;
					}

					public void setUrls(Url[] urls) {
						this.urls = urls;
					}

					public User_mention[] getUser_mentions() {
						return user_mentions;
					}

					public void setUser_mentions(User_mention[] user_mentions) {
						this.user_mentions = user_mentions;
					}

					public Symbol[] getSymbols() {
						return symbols;
					}

					public void setSymbols(Symbol[] symbols) {
						this.symbols = symbols;
					}

					public   Url urls[];
                    public   User_mention user_mentions[];
                    public   Symbol symbols[];
            
                    public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                        this.hashtags = hashtags;
                        this.urls = urls;
                        this.user_mentions = user_mentions;
                        this.symbols = symbols;
                    }
            
                    public static   class Hashtag {
                        public   String text;
                        public String getText() {
							return text;
						}

						public void setText(String text) {
							this.text = text;
						}

						public int[] getIndices() {
							return indices;
						}

						public void setIndices(int[] indices) {
							this.indices = indices;
						}

						public   int[] indices;
                
                        public Hashtag(String text, int[] indices){
                            this.text = text;
                            this.indices = indices;
                        }
                    }
            
                    public static   class Url {
                        public   String url;
                        public String getUrl() {
							return url;
						}

						public void setUrl(String url) {
							this.url = url;
						}

						public String getExpanded_url() {
							return expanded_url;
						}

						public void setExpanded_url(String expanded_url) {
							this.expanded_url = expanded_url;
						}

						public String getDisplay_url() {
							return display_url;
						}

						public void setDisplay_url(String display_url) {
							this.display_url = display_url;
						}

						public int[] getIndices() {
							return indices;
						}

						public void setIndices(int[] indices) {
							this.indices = indices;
						}

						public   String expanded_url;
                        public   String display_url;
                        public   int[] indices;
                
                        public Url(String url, String expanded_url, String display_url, int[] indices){
                            this.url = url;
                            this.expanded_url = expanded_url;
                            this.display_url = display_url;
                            this.indices = indices;
                        }
                    }
            
                    public static   class User_mention {
                        public   String screen_name;
                        public String getScreen_name() {
							return screen_name;
						}

						public void setScreen_name(String screen_name) {
							this.screen_name = screen_name;
						}

						public String getName() {
							return name;
						}

						public void setName(String name) {
							this.name = name;
						}

						public long getId() {
							return id;
						}

						public void setId(long id) {
							this.id = id;
						}

						public String getId_str() {
							return id_str;
						}

						public void setId_str(String id_str) {
							this.id_str = id_str;
						}

						public int[] getIndices() {
							return indices;
						}

						public void setIndices(int[] indices) {
							this.indices = indices;
						}

						public   String name;
                        public   long id;
                        public   String id_str;
                        public   int[] indices;
                
                        public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                            this.screen_name = screen_name;
                            this.name = name;
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                        }
                    }
            
                    public static   class Symbol {
                
                        public Symbol(){
                        }
                    }
                }
            }
    
            public static   class Entities {
                public   Hashtag hashtags[];
                public   Url urls[];
                public Hashtag[] getHashtags() {
					return hashtags;
				}

				public void setHashtags(Hashtag[] hashtags) {
					this.hashtags = hashtags;
				}

				public Url[] getUrls() {
					return urls;
				}

				public void setUrls(Url[] urls) {
					this.urls = urls;
				}

				public User_mention[] getUser_mentions() {
					return user_mentions;
				}

				public void setUser_mentions(User_mention[] user_mentions) {
					this.user_mentions = user_mentions;
				}

				public Symbol[] getSymbols() {
					return symbols;
				}

				public void setSymbols(Symbol[] symbols) {
					this.symbols = symbols;
				}

				public   User_mention user_mentions[];
                public   Symbol symbols[];
        
                public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                    this.hashtags = hashtags;
                    this.urls = urls;
                    this.user_mentions = user_mentions;
                    this.symbols = symbols;
                }
        
                public static   class Hashtag {
            
                    public Hashtag(){
                    }
                }
        
                public static   class Url {
                    public   String url;
                    public   String expanded_url;
                    public   String display_url;
                    public   int[] indices;
            
                    public Url(String url, String expanded_url, String display_url, int[] indices){
                        this.url = url;
                        this.expanded_url = expanded_url;
                        this.display_url = display_url;
                        this.indices = indices;
                    }
                }
        
                public static   class User_mention {
                    public   String screen_name;
                    public   String name;
                    public   long id;
                    public   String id_str;
                    public   int[] indices;
            
                    public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                        this.screen_name = screen_name;
                        this.name = name;
                        this.id = id;
                        this.id_str = id_str;
                        this.indices = indices;
                    }
                }
        
                public static   class Symbol {
            
                    public Symbol(){
                    }
                }
            }
        }

        public static   class User {
            public   long id;
            public   String id_str;
            public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getId_str() {
				return id_str;
			}

			public void setId_str(String id_str) {
				this.id_str = id_str;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getScreen_name() {
				return screen_name;
			}

			public void setScreen_name(String screen_name) {
				this.screen_name = screen_name;
			}

			public String getLocation() {
				return location;
			}

			public void setLocation(String location) {
				this.location = location;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public String getTranslator_type() {
				return translator_type;
			}

			public void setTranslator_type(String translator_type) {
				this.translator_type = translator_type;
			}

			public boolean is_protected() {
				return _protected;
			}

			public void set_protected(boolean _protected) {
				this._protected = _protected;
			}

			public boolean isVerified() {
				return verified;
			}

			public void setVerified(boolean verified) {
				this.verified = verified;
			}

			public long getFollowers_count() {
				return followers_count;
			}

			public void setFollowers_count(long followers_count) {
				this.followers_count = followers_count;
			}

			public long getFriends_count() {
				return friends_count;
			}

			public void setFriends_count(long friends_count) {
				this.friends_count = friends_count;
			}

			public long getListed_count() {
				return listed_count;
			}

			public void setListed_count(long listed_count) {
				this.listed_count = listed_count;
			}

			public long getFavourites_count() {
				return favourites_count;
			}

			public void setFavourites_count(long favourites_count) {
				this.favourites_count = favourites_count;
			}

			public long getStatuses_count() {
				return statuses_count;
			}

			public void setStatuses_count(long statuses_count) {
				this.statuses_count = statuses_count;
			}

			public String getCreated_at() {
				return created_at;
			}

			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			public Utc_offset getUtc_offset() {
				return utc_offset;
			}

			public void setUtc_offset(Utc_offset utc_offset) {
				this.utc_offset = utc_offset;
			}

			public Time_zone getTime_zone() {
				return time_zone;
			}

			public void setTime_zone(Time_zone time_zone) {
				this.time_zone = time_zone;
			}

			public boolean isGeo_enabled() {
				return geo_enabled;
			}

			public void setGeo_enabled(boolean geo_enabled) {
				this.geo_enabled = geo_enabled;
			}

			public String getLang() {
				return lang;
			}

			public void setLang(String lang) {
				this.lang = lang;
			}

			public boolean isContributors_enabled() {
				return contributors_enabled;
			}

			public void setContributors_enabled(boolean contributors_enabled) {
				this.contributors_enabled = contributors_enabled;
			}

			public boolean isIs_translator() {
				return is_translator;
			}

			public void setIs_translator(boolean is_translator) {
				this.is_translator = is_translator;
			}

			public String getProfile_background_color() {
				return profile_background_color;
			}

			public void setProfile_background_color(String profile_background_color) {
				this.profile_background_color = profile_background_color;
			}

			public String getProfile_background_image_url() {
				return profile_background_image_url;
			}

			public void setProfile_background_image_url(String profile_background_image_url) {
				this.profile_background_image_url = profile_background_image_url;
			}

			public String getProfile_background_image_url_https() {
				return profile_background_image_url_https;
			}

			public void setProfile_background_image_url_https(String profile_background_image_url_https) {
				this.profile_background_image_url_https = profile_background_image_url_https;
			}

			public boolean isProfile_background_tile() {
				return profile_background_tile;
			}

			public void setProfile_background_tile(boolean profile_background_tile) {
				this.profile_background_tile = profile_background_tile;
			}

			public String getProfile_link_color() {
				return profile_link_color;
			}

			public void setProfile_link_color(String profile_link_color) {
				this.profile_link_color = profile_link_color;
			}

			public String getProfile_sidebar_border_color() {
				return profile_sidebar_border_color;
			}

			public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
				this.profile_sidebar_border_color = profile_sidebar_border_color;
			}

			public String getProfile_sidebar_fill_color() {
				return profile_sidebar_fill_color;
			}

			public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
				this.profile_sidebar_fill_color = profile_sidebar_fill_color;
			}

			public String getProfile_text_color() {
				return profile_text_color;
			}

			public void setProfile_text_color(String profile_text_color) {
				this.profile_text_color = profile_text_color;
			}

			public boolean isProfile_use_background_image() {
				return profile_use_background_image;
			}

			public void setProfile_use_background_image(boolean profile_use_background_image) {
				this.profile_use_background_image = profile_use_background_image;
			}

			public String getProfile_image_url() {
				return profile_image_url;
			}

			public void setProfile_image_url(String profile_image_url) {
				this.profile_image_url = profile_image_url;
			}

			public String getProfile_image_url_https() {
				return profile_image_url_https;
			}

			public void setProfile_image_url_https(String profile_image_url_https) {
				this.profile_image_url_https = profile_image_url_https;
			}

			public String getProfile_banner_url() {
				return profile_banner_url;
			}

			public void setProfile_banner_url(String profile_banner_url) {
				this.profile_banner_url = profile_banner_url;
			}

			public boolean isDefault_profile() {
				return default_profile;
			}

			public void setDefault_profile(boolean default_profile) {
				this.default_profile = default_profile;
			}

			public boolean isDefault_profile_image() {
				return default_profile_image;
			}

			public void setDefault_profile_image(boolean default_profile_image) {
				this.default_profile_image = default_profile_image;
			}

			public Following getFollowing() {
				return following;
			}

			public void setFollowing(Following following) {
				this.following = following;
			}

			public Follow_request_sent getFollow_request_sent() {
				return follow_request_sent;
			}

			public void setFollow_request_sent(Follow_request_sent follow_request_sent) {
				this.follow_request_sent = follow_request_sent;
			}

			public Notifications getNotifications() {
				return notifications;
			}

			public void setNotifications(Notifications notifications) {
				this.notifications = notifications;
			}

			public   String name;
            public   String screen_name;
            public   String location;
            public   String url;
            public   String description;
            public   String translator_type;
            public   boolean _protected;
            public   boolean verified;
            public   long followers_count;
            public   long friends_count;
            public   long listed_count;
            public   long favourites_count;
            public   long statuses_count;
            public   String created_at;
            public   Utc_offset utc_offset;
            public   Time_zone time_zone;
            public   boolean geo_enabled;
            public   String lang;
            public   boolean contributors_enabled;
            public   boolean is_translator;
            public   String profile_background_color;
            public   String profile_background_image_url;
            public   String profile_background_image_url_https;
            public   boolean profile_background_tile;
            public   String profile_link_color;
            public   String profile_sidebar_border_color;
            public   String profile_sidebar_fill_color;
            public   String profile_text_color;
            public   boolean profile_use_background_image;
            public   String profile_image_url;
            public   String profile_image_url_https;
            public   String profile_banner_url;
            public   boolean default_profile;
            public   boolean default_profile_image;
            public   Following following;
            public   Follow_request_sent follow_request_sent;
            public   Notifications notifications;
    
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
    
            public static   class Utc_offset {
        
                public Utc_offset(){
                }
            }
    
            public static   class Time_zone {
        
                public Time_zone(){
                }
            }
    
            public static   class Following {
        
                public Following(){
                }
            }
    
            public static   class Follow_request_sent {
        
                public Follow_request_sent(){
                }
            }
    
            public static   class Notifications {
        
                public Notifications(){
                }
            }
        }
    }
}