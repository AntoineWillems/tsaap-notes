/*
 * Copyright 2013 Tsaap Development Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tsaap.notes

import org.tsaap.directory.User

class Note {
  Date dateCreated
  User author
  Context context
  Tag fragmentTag
  Note parentNote

  String content

  static hasMany = [bookmarks:Bookmark]

  static constraints = {
    context nullable: true
    fragmentTag nullable: true
    parentNote nullable: true
    bookmarks nullable: true
    content maxSize: 280
  }

  static mapping = {
    version false
  }

  /**
   * Indicate if the current note is bookmarked by the given user
   * @param user the user
   * @return true if the note is bookmarked, false if not
   */
  boolean isBookmarkedByUser(User user) {
    Bookmark.findByNoteAndUser(this,user)
  }

  /**
   * Indicate if a note has a parent note
   * @return true if the note has a parent, false if not
   */
  boolean hasParent() {
    parentNote
  }
}
