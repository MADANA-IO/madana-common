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

public final class MDN_TweetCreateEvent {
    public final String for_user_id;
    public final Tweet_create_event tweet_create_events[];

    public MDN_TweetCreateEvent(String for_user_id, Tweet_create_event[] tweet_create_events){
        this.for_user_id = for_user_id;
        this.tweet_create_events = tweet_create_events;
    }

    public static final class Tweet_create_event {
        public final String created_at;
        public final long id;
        public final String id_str;
        public final String text;
        public final String source;
        public final boolean truncated;
        public final User user;
        public final Retweeted_status retweeted_status;
        public final boolean is_quote_status;
        public final long quote_count;
        public final long reply_count;
        public final long retweet_count;
        public final long favorite_count;
        public final Entities entities;
        public final boolean favorited;
        public final boolean retweeted;
        public final String filter_level;
        public final String lang;
        public final String timestamp_ms;

        public Tweet_create_event(String created_at, long id, String id_str, String text, String source, boolean truncated, User user, Retweeted_status retweeted_status, boolean is_quote_status, long quote_count, long reply_count, long retweet_count, long favorite_count, Entities entities, boolean favorited, boolean retweeted, String filter_level, String lang, String timestamp_ms){
            this.created_at = created_at;
            this.id = id;
            this.id_str = id_str;
            this.text = text;
            this.source = source;
            this.truncated = truncated;
            this.user = user;
            this.retweeted_status = retweeted_status;
            this.is_quote_status = is_quote_status;
            this.quote_count = quote_count;
            this.reply_count = reply_count;
            this.retweet_count = retweet_count;
            this.favorite_count = favorite_count;
            this.entities = entities;
            this.favorited = favorited;
            this.retweeted = retweeted;
            this.filter_level = filter_level;
            this.lang = lang;
            this.timestamp_ms = timestamp_ms;
        }

        public static final class User {
            public final long id;
            public final String id_str;
            public final String name;
            public final String screen_name;
            public final Location location;
            public final Url url;
            public final Description description;
            public final String translator_type;
            public final boolean _protected;
            public final boolean verified;
            public final long followers_count;
            public final long friends_count;
            public final long listed_count;
            public final long favourites_count;
            public final long statuses_count;
            public final String created_at;
            public final Utc_offset utc_offset;
            public final Time_zone time_zone;
            public final boolean geo_enabled;
            public final String lang;
            public final boolean contributors_enabled;
            public final boolean is_translator;
            public final String profile_background_color;
            public final String profile_background_image_url;
            public final String profile_background_image_url_https;
            public final boolean profile_background_tile;
            public final String profile_link_color;
            public final String profile_sidebar_border_color;
            public final String profile_sidebar_fill_color;
            public final String profile_text_color;
            public final boolean profile_use_background_image;
            public final String profile_image_url;
            public final String profile_image_url_https;
            public final String profile_banner_url;
            public final boolean default_profile;
            public final boolean default_profile_image;
            public final Following following;
            public final Follow_request_sent follow_request_sent;
            public final Notifications notifications;
    
            public User(long id, String id_str, String name, String screen_name, Location location, Url url, Description description, String translator_type, boolean _protected, boolean verified, long followers_count, long friends_count, long listed_count, long favourites_count, long statuses_count, String created_at, Utc_offset utc_offset, Time_zone time_zone, boolean geo_enabled, String lang, boolean contributors_enabled, boolean is_translator, String profile_background_color, String profile_background_image_url, String profile_background_image_url_https, boolean profile_background_tile, String profile_link_color, String profile_sidebar_border_color, String profile_sidebar_fill_color, String profile_text_color, boolean profile_use_background_image, String profile_image_url, String profile_image_url_https, String profile_banner_url, boolean default_profile, boolean default_profile_image, Following following, Follow_request_sent follow_request_sent, Notifications notifications){
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
    
            public static final class Location {
        
                public Location(){
                }
            }
    
            public static final class Url {
        
                public Url(){
                }
            }
    
            public static final class Description {
        
                public Description(){
                }
            }
    
            public static final class Utc_offset {
        
                public Utc_offset(){
                }
            }
    
            public static final class Time_zone {
        
                public Time_zone(){
                }
            }
    
            public static final class Following {
        
                public Following(){
                }
            }
    
            public static final class Follow_request_sent {
        
                public Follow_request_sent(){
                }
            }
    
            public static final class Notifications {
        
                public Notifications(){
                }
            }
        }

        public static final class Retweeted_status {
            public final String created_at;
            public final long id;
            public final String id_str;
            public final String text;
            public final int[] display_text_range;
            public final String source;
            public final boolean truncated;
            public final In_reply_to_status_id in_reply_to_status_id;
            public final In_reply_to_status_id_str in_reply_to_status_id_str;
            public final In_reply_to_user_id in_reply_to_user_id;
            public final In_reply_to_user_id_str in_reply_to_user_id_str;
            public final In_reply_to_screen_name in_reply_to_screen_name;
            public final User user;
            public final Geo geo;
            public final Coordinates coordinates;
            public final Place place;
            public final Contributors contributors;
            public final boolean is_quote_status;
            public final Extended_tweet extended_tweet;
            public final long quote_count;
            public final long reply_count;
            public final long retweet_count;
            public final long favorite_count;
            public final Entities entities;
            public final boolean favorited;
            public final boolean retweeted;
            public final boolean possibly_sensitive;
            public final String filter_level;
            public final String lang;
    
            public Retweeted_status(String created_at, long id, String id_str, String text, int[] display_text_range, String source, boolean truncated, In_reply_to_status_id in_reply_to_status_id, In_reply_to_status_id_str in_reply_to_status_id_str, In_reply_to_user_id in_reply_to_user_id, In_reply_to_user_id_str in_reply_to_user_id_str, In_reply_to_screen_name in_reply_to_screen_name, User user, Geo geo, Coordinates coordinates, Place place, Contributors contributors, boolean is_quote_status, Extended_tweet extended_tweet, long quote_count, long reply_count, long retweet_count, long favorite_count, Entities entities, boolean favorited, boolean retweeted, boolean possibly_sensitive, String filter_level, String lang){
                this.created_at = created_at;
                this.id = id;
                this.id_str = id_str;
                this.text = text;
                this.display_text_range = display_text_range;
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
    
            public static final class In_reply_to_status_id {
        
                public In_reply_to_status_id(){
                }
            }
    
            public static final class In_reply_to_status_id_str {
        
                public In_reply_to_status_id_str(){
                }
            }
    
            public static final class In_reply_to_user_id {
        
                public In_reply_to_user_id(){
                }
            }
    
            public static final class In_reply_to_user_id_str {
        
                public In_reply_to_user_id_str(){
                }
            }
    
            public static final class In_reply_to_screen_name {
        
                public In_reply_to_screen_name(){
                }
            }
    
            public static final class User {
                public final long id;
                public final String id_str;
                public final String name;
                public final String screen_name;
                public final String location;
                public final String url;
                public final String description;
                public final String translator_type;
                public final boolean _protected;
                public final boolean verified;
                public final long followers_count;
                public final long friends_count;
                public final long listed_count;
                public final long favourites_count;
                public final long statuses_count;
                public final String created_at;
                public final Utc_offset utc_offset;
                public final Time_zone time_zone;
                public final boolean geo_enabled;
                public final String lang;
                public final boolean contributors_enabled;
                public final boolean is_translator;
                public final String profile_background_color;
                public final String profile_background_image_url;
                public final String profile_background_image_url_https;
                public final boolean profile_background_tile;
                public final String profile_link_color;
                public final String profile_sidebar_border_color;
                public final String profile_sidebar_fill_color;
                public final String profile_text_color;
                public final boolean profile_use_background_image;
                public final String profile_image_url;
                public final String profile_image_url_https;
                public final String profile_banner_url;
                public final boolean default_profile;
                public final boolean default_profile_image;
                public final Following following;
                public final Follow_request_sent follow_request_sent;
                public final Notifications notifications;
        
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
        
                public static final class Utc_offset {
            
                    public Utc_offset(){
                    }
                }
        
                public static final class Time_zone {
            
                    public Time_zone(){
                    }
                }
        
                public static final class Following {
            
                    public Following(){
                    }
                }
        
                public static final class Follow_request_sent {
            
                    public Follow_request_sent(){
                    }
                }
        
                public static final class Notifications {
            
                    public Notifications(){
                    }
                }
            }
    
            public static final class Geo {
        
                public Geo(){
                }
            }
    
            public static final class Coordinates {
        
                public Coordinates(){
                }
            }
    
            public static final class Place {
        
                public Place(){
                }
            }
    
            public static final class Contributors {
        
                public Contributors(){
                }
            }
    
            public static final class Extended_tweet {
                public final String full_text;
                public final int[] display_text_range;
                public final Entities entities;
                public final Extended_entities extended_entities;
        
                public Extended_tweet(String full_text, int[] display_text_range, Entities entities, Extended_entities extended_entities){
                    this.full_text = full_text;
                    this.display_text_range = display_text_range;
                    this.entities = entities;
                    this.extended_entities = extended_entities;
                }
        
                public static final class Entities {
                    public final Hashtag hashtags[];
                    public final Url urls[];
                    public final User_mention user_mentions[];
                    public final Symbol symbols[];
                    public final Media media[];
            
                    public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols, Media[] media){
                        this.hashtags = hashtags;
                        this.urls = urls;
                        this.user_mentions = user_mentions;
                        this.symbols = symbols;
                        this.media = media;
                    }
            
                    public static final class Hashtag {
                        public final String text;
                        public final int[] indices;
                
                        public Hashtag(String text, int[] indices){
                            this.text = text;
                            this.indices = indices;
                        }
                    }
            
                    public static final class Url {
                
                        public Url(){
                        }
                    }
            
                    public static final class User_mention {
                        public final String screen_name;
                        public final String name;
                        public final long id;
                        public final String id_str;
                        public final int[] indices;
                
                        public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                            this.screen_name = screen_name;
                            this.name = name;
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                        }
                    }
            
                    public static final class Symbol {
                
                        public Symbol(){
                        }
                    }
            
                    public static final class Media {
                        public final long id;
                        public final String id_str;
                        public final int[] indices;
                        public final String media_url;
                        public final String media_url_https;
                        public final String url;
                        public final String display_url;
                        public final String expanded_url;
                        public final String type;
                        public final Sizes sizes;
                
                        public Media(long id, String id_str, int[] indices, String media_url, String media_url_https, String url, String display_url, String expanded_url, String type, Sizes sizes){
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                            this.media_url = media_url;
                            this.media_url_https = media_url_https;
                            this.url = url;
                            this.display_url = display_url;
                            this.expanded_url = expanded_url;
                            this.type = type;
                            this.sizes = sizes;
                        }
                
                        public static final class Sizes {
                            public final Medium medium;
                            public final Thumb thumb;
                            public final Large large;
                            public final Small small;
                    
                            public Sizes(Medium medium, Thumb thumb, Large large, Small small){
                                this.medium = medium;
                                this.thumb = thumb;
                                this.large = large;
                                this.small = small;
                            }
                    
                            public static final class Medium {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Medium(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            public static final class Thumb {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Thumb(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            public static final class Large {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Large(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            public static final class Small {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Small(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                        }
                    }
                }
        
                public static final class Extended_entities {
                    public final Media media[];
            
                    public Extended_entities(Media[] media){
                        this.media = media;
                    }
            
                    public static final class Media {
                        public final long id;
                        public final String id_str;
                        public final int[] indices;
                        public final String media_url;
                        public final String media_url_https;
                        public final String url;
                        public final String display_url;
                        public final String expanded_url;
                        public final String type;
                        public final Sizes sizes;
                
                        public Media(long id, String id_str, int[] indices, String media_url, String media_url_https, String url, String display_url, String expanded_url, String type, Sizes sizes){
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                            this.media_url = media_url;
                            this.media_url_https = media_url_https;
                            this.url = url;
                            this.display_url = display_url;
                            this.expanded_url = expanded_url;
                            this.type = type;
                            this.sizes = sizes;
                        }
                
                        public static final class Sizes {
                            public final Medium medium;
                            public final Thumb thumb;
                            public final Large large;
                            public final Small small;
                    
                            public Sizes(Medium medium, Thumb thumb, Large large, Small small){
                                this.medium = medium;
                                this.thumb = thumb;
                                this.large = large;
                                this.small = small;
                            }
                    
                            public static final class Medium {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Medium(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            public static final class Thumb {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Thumb(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            public static final class Large {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Large(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            public static final class Small {
                                public final long w;
                                public final long h;
                                public final String resize;
                        
                                public Small(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                        }
                    }
                }
            }
    
            public static final class Entities {
                public final Hashtag hashtags[];
                public final Url urls[];
                public final User_mention user_mentions[];
                public final Symbol symbols[];
        
                public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                    this.hashtags = hashtags;
                    this.urls = urls;
                    this.user_mentions = user_mentions;
                    this.symbols = symbols;
                }
        
                public static final class Hashtag {
                    public final String text;
                    public final int[] indices;
            
                    public Hashtag(String text, int[] indices){
                        this.text = text;
                        this.indices = indices;
                    }
                }
        
                public static final class Url {
                    public final String url;
                    public final String expanded_url;
                    public final String display_url;
                    public final int[] indices;
            
                    public Url(String url, String expanded_url, String display_url, int[] indices){
                        this.url = url;
                        this.expanded_url = expanded_url;
                        this.display_url = display_url;
                        this.indices = indices;
                    }
                }
        
                public static final class User_mention {
                    public final String screen_name;
                    public final String name;
                    public final long id;
                    public final String id_str;
                    public final int[] indices;
            
                    public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                        this.screen_name = screen_name;
                        this.name = name;
                        this.id = id;
                        this.id_str = id_str;
                        this.indices = indices;
                    }
                }
        
                public static final class Symbol {
            
                    public Symbol(){
                    }
                }
            }
        }

        public static final class Entities {
            public final Hashtag hashtags[];
            public final Url urls[];
            public final User_mention user_mentions[];
            public final Symbol symbols[];
    
            public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                this.hashtags = hashtags;
                this.urls = urls;
                this.user_mentions = user_mentions;
                this.symbols = symbols;
            }
    
            public static final class Hashtag {
                public final String text;
                public final int[] indices;
        
                public Hashtag(String text, int[] indices){
                    this.text = text;
                    this.indices = indices;
                }
            }
    
            public static final class Url {
        
                public Url(){
                }
            }
    
            public static final class User_mention {
                public final String screen_name;
                public final String name;
                public final long id;
                public final String id_str;
                public final int[] indices;
        
                public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                    this.screen_name = screen_name;
                    this.name = name;
                    this.id = id;
                    this.id_str = id_str;
                    this.indices = indices;
                }
            }
    
            public static final class Symbol {
        
                public Symbol(){
                }
            }
        }
    }
}
