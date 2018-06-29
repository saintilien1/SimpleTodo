# Pre-work - *Simple Todo*

**SimpleTodo** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Saintilien Wilson**

Time spent: **40** hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **successfully add and remove items** from the todo list
* [X] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [X] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [X] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src=https://imgur.com/a/PdenJSb' title='Video SimpleTodo' width='' alt='Video SimpleTodo' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** [I really like the Android app development platform. Something I have noticed is that, devloping Applications for Android require that you master Java. As I had a Java Class and took advantage of it this year, it was not difficult for me to handle the codes. Back in the days, I had to use LiveCode for personal use, a framework which helps us developing application for multiplatforms. From my experiences, I see that Android is more simpler than LiveCode. We don't really have to write a lot of codes as there are many components already available. And also, regarding the controller aspect, it is easier for users to navigate from page to page when calling activities. The logic for the LiveCode is creating a Stack with different cards. Because LiveCode don't create native app, when building for example an application on any platform, the navigation is not fluid.].

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** [An adapter is an object that controls an AdapterView and the items that this AdapterView contains. The adapter is important because, as we can see in my application, this is the ArrayAdapter that helps me manage the ListView and the containing items. Convert View is used to reuse old views when caling the getView method which helps the Adapter populating each list item with a View object.].

## Notes

Describe any challenges encountered while building the app.
	When I was creating the edit feature, I had to deal with many conflicts. Since I put the codes for editing, I could not add new items. Therefore, I have allocated a lot of time doing ressearches on how to manage this issue. At last, I fixed it.	
## License

    Copyright [2018] [wilson of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
