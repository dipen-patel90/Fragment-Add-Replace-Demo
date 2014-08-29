Fragment-Add-Replace-Demo
=========================

Fragment Add Replace Demo

Adding here Fragment demo which "Add" & "Replace" fragment in fragment holder.

Adding demo app for::

Fragment
Add & Replace fragment
Different UI for different orientation
Maintaining BackStack of Fragment


We will add different layout xml in different layout folder "layout" & "layout-land" to render differently on 
different orientation.

When we "Replace" fragment it will detach existing fragment and "Add" new fragment. 
When we "Add" fragment it will add new fragment and existing fragment remain same.

We can maintain back stack of fragment which can be accessible later.
  /**
   * We can add name to this back stack and we can access this fragment by name later.
     Otherwise we can pass null to parameter*/
    fragmentTwoTransaction.addToBackStack(null);  

