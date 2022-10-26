---
layout: page
title: User Guide
---

**UniNurse** is a desktop app tailored for you, a **private duty nurse**, to:
- Manage your patients' contacts.
- Organize your patient-related tasks.
- Keep track of your patients' medical conditions.

<div markdown="block" class="alert alert-info">

**Fastest fingers first!**

If your fingers are as quick as your wit, UniNurse helps you to get your patient management tasks done in no time!
It leverages on a no-frills _Command Line Interface (CLI)_ to give fast typists such as yourself a painless user
experience.

</div>

UniNurse offers the following features:
- Add details such as phone numbers, addresses and more.
- Find any patient by name _(more to be added later...)_.
- Add tasks to a patient.
- Categorize patients using tags.

--------------------------------------------------------------------------------------------------------------------

### Using this guide

This guide walks you through all the features of UniNurse, as well as tips, so you can reap all the benefits of
UniNurse!

If you are a **new user**, this guide equips you with the necessary know-how to [get started](#quick-start)
with UniNurse.

If you are an **experienced user**, you can refer to the [Command Summary](#command-summary) at the end of this guide.

--------------------------------------------------------------------------------------------------------------------

### Table of Contents

* Table of Contents

  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have [Java 11](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html) or above
   installed on your computer. To check your Java version, open a Command Prompt or Terminal window and type:

```
java -version
```

2. Download the latest `uninurse.jar` [here](https://github.com/AY2223S1-CS2103T-T12-4/tp/releases).
3. Move `uninurse.jar` to the folder you want to use as the home folder for UniNurse.
4. Double-click the file to start UniNurse. A user interface similar to the one below should appear in a few seconds.

<div markdown="block" class="alert alert-info">

:bulb: **Tip:** The app comes with some sample contacts by default. Type `clear` in the command box to remove them.

</div>

![Ui](images/Ui.png)

5. Type your command in the command box and hit `Enter` to execute the command. Here are some example commands
   you can try:
    * **`help`**: Opens the help window.
    * **`add`**`n/Jane Doe p/91234567 e/janed@example.com a/20 Anderson Road, block 123, #01-01`: Adds a
      patient named `Jane Doe` to your contacts.
    * **`delete`**`3`: Deletes the 3rd contact shown in the current list.
    * **`list`**: Lists all contacts.
    * **`clear`**: Deletes all contacts.
    * **`exit`**: Exits from UniNurse.
6. Refer to the [Features](#features) below for details of each command. Alternatively, you may refer to the
   [Command Summary](#command-summary) at the end of this guide.
--------------------------------------------------------------------------------------------------------------------

## Features

**Before we begin, let us understand the technical terminologies used:**

| Word         | Meaning                                                                                                                                                                                   |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Command      | A sentence which the user inputs to                                                                                                                                                       |
| Command word | The first word of every command.                                                                                                                                                          |
| Option       | Part of the user input specifying the options for a command, which is preceded by a flag.                                                                                                 |
| Flag         | Part of the user input that allows the user to specify the specific options for a command, consisting of a letter preceded by a hyphen. <br> Type of flags: `-p`, `-t`.                   |
| Parameter    | Part of the user input consisting of information supplied by the user to UniNurse, which is preceded by a prefix.                                                                         |
| Prefix       | Part of the user input that allows the user to specify information for a patient, consisting of a letter preceded by a hyphen. <br> Type of prefixes: `n/`, `p/`, `e/`, `a/`, `t/`, `d/`. |


<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* All flags and options must be specified before any prefix or parameter.

* Flags can be in any order.<br>
  e.g. if the command specifies `-p PATIENT_INDEX -t TASK_INDEX`, `-t TASK_INDEX -p PATIENT_INDEX` is also acceptable.

* There must be a space separating a flag and an option.

* All indices ***must be a positive integer*** 1, 2, 3, …

* `PATIENT_INDEX` refers to the index number shown in the displayed patient list.

* Indices for patient attributes (e.g. `TASK_INDEX`, `CONDITION_INDEX`, `TAG_INDEX`, etc.) refers to the index number shown in the attribute list of a patient.<br>
  e.g. `TASK_INDEX` refers to the index number show in the task list of a patient.

* Parameters in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Parameters with `…` after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

Format: `help`

![help message](images/helpMessage.png)
_Help window displayed after running the `help` command_

### Adding a patient: `add`

Adds a patient to the patient list.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [d/TASK_DESCRIPTION | DATE_AND_TIME | FREQUENCY]… [t/TAG]…`

* `DATE_AND_TIME` should be in the format like 16-10-2022 1030
* If no `DATE_AND_TIME` is provided, then a default date and time of 24 hours from creation will be set
* Frequency can be `daily`, `weekly` or `monthly` or empty if it's a one off task, however a `DATE_AND_TIME` must be provided inorder to set a recurring task.
* Note that capitalization does not matter for frequency.

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 d/Administer 3ml of example medicine | 16-10-2022 1030 t/Severe`
* `add n/Betsy Crowe p/87901234 e/betsy@example.com a/Jane street blk 420 #01-69 d/Change dressing on left arm t/Low Risk`
* `add n/Tom pitt p/90904213 e/pitts@example.com a/Bourvard street blk 341 #04-17 d/Moniter blood pressure | 23-10-2022 1200 | daily`

### Editing a patient’s details : `edit -p`

Edits an existing patient in the patient list.

Format: `edit -p INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]`

* Edits the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient list.
* The index ***must be a positive integer*** 1, 2, 3, …
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.
* You can remove all the patient’s tags by typing t/ without specifying any tags after it.

Example:

* `edit -p 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st patient to be `91234567` and `johndoe@example.com` respectively.
* `edit -p 2 n/Betsy Crower t/` Edits the name of the 2nd patient to be `Betsy Crower` and clears all existing tags.

### Deleting a patient: `delete -p`

Deletes the specified patient from the patient list.

Format: `delete -p INDEX`

* Deletes the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete -p 2` deletes the 2nd patient in the patient book.
* `find Betsy` followed by `delete -p 1` deletes the 1st patient in the results of the `find` command.

### Listing all patients: `list`

Shows a list of all patients.

Format: `list`

### Listing all patients for the day: `patientsToday`

Shows a list of all patients with tasks due today.

Format: `patientsToday`

### Listing all tasks for a particular day: `tasksOn`

Shows a list of all tasks on a particular day.

Format: `tasksOn DATE`

* The DATE **must be of the specified format** dd-MM-yyyy

Examples:
* `tasksOn 25-12-2022` lists the tasks on 25th December 2022

### Finding patients: `find`

Finds patients whose names contain any of the given keywords.

Format: `find [KEYWORD]… [n/NAME]… [p/PHONE]… [e/EMAIL]… [a/ADDRESS]… [t/TAG]… [c/CONDITION]… [d/TASK_DESCRIPTION]… [m/MEDICATION]…`

* There should be at least one parameter for the command.
* The search is case-insensitive. e.g `hans` will match `Hans`.
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
* Partial words can be matched e.g. `Han` will match `Hans`.
* Patients matching at least one keyword in every parameter type will be returned (i.e. AND search for different parameters, OR search for same parameter). In more details,
  * At least one of the patient's details (name, phone, email, address, tag, condition, task description, or medication) must match with at least one `KEYWORD`.
  * The patient's name must match at least one `NAME` parameter.
  * The patient's phone must match at least one `PHONE` parameter.
  * The patient's email must match at least one `EMAIL` parameter.
  * The patient's address must match at least one `ADDRESS` parameter.
  * The patient's tag must match at least one `TAG` parameter.
  * The patient's condition must match at least one `CONDITION` parameter.
  * The patient's medication must match at least one `MEDICATION` parameter.

Examples:
* `find jo` returns patients with names `Joe` and `John`, patients with emails `jo@example.com`, and patients with tag `joints`.
* `find alex david` returns `Alex Yeoh` & `David Li`.
  ![result for 'find alex david'](images/findAlexDavidResult.png)
  _Contact list displayed after running the `find alex david` command_
* `find key n/John n/Betsy n/Charlie e/@example.com` returns patients who fulfill all conditions below:
  * The patient's name contains either `John` or `Betsy` or `Charlie`.
  * The patient's email address must contain `@example.com`.
  * At least one of the patient's details must contain `key` (e.g., their tag).

### Adding a task: `add -p`

Adds a task or recurring task to a patient.

Format: `add -p PATIENT_INDEX d/TASK_DESCRIPTION | DATE_AND_TIME | FREQUENCY`

* Adds a task to a patient at the specified `PATIENT_INDEX`.
* The patient index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …
* `DATE_AND_TIME` should be in the format like 16-10-2022 1030
* If no `DATE_AND_TIME` is provided, then a default date and time of 24 hours from creation will be set
* Frequency is an optional tag that is used to specify recurring tasks, the valid values for this field are `daily`, `weekly` and `monthly`. Capitalisation does not matter
* If a frequency is not specified, it's a normal task
* Note that both `DATE_AND_TIME` and `FREQUENCY` are optional fields, however to have a recurring task both of them are required, while you can have a normal task with date time not be recurring, i.e `FREQUENCY` not required

Examples:
* `list` followed by `add -p 1 d/Administer 3ml of example medicine` adds a task to the 1st patient in the patient list.
* `find Betsy` followed by `add -p 2 d/Change dressing on left arm | 12-07-2022` adds a task to the 2nd patient in results of the `find` command, on 12th July 2022 .

### Editing a task: `edit -p -t`

Edits the specified task or recurring task associated with a patient.

Format: `edit -p PATIENT_INDEX -t TASK_INDEX d/TASK_DESCRIPTION | DATE_AND_TIME | FREQUENCY`

* Edits the task at the specified `TASK_INDEX` of the patient at the specified `PATIENT_INDEX`.
* The task index refers to the index number shown in the task list of a patient.
* The patient index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …
* `DATE_AND_TIME` should be in the format like 16-10-2022 1030
* `FREQUENCY` should either be `daily`. `weekly` or `monthly`. Capitalisation does not matter.
* If no new `DATE_AND_TIME` or `FREQUENCY` are provided, then original values will be used or in the case of `FREQUENCY` nothing will change i.e it will remain a normal task
* If a `FREQUENCY` is provided for what was originally a non recurring task, the edit will transform it into a recurring one based on the given frequency
* To keep the original task description and edit only the `DATE_AND_TIME` or `FREQUENCY` fields, simply copy the task description and only change the desired `DATE_AND_TIME` or `FREQUENCY` field

Examples:
* `list` followed by `edit -p 1 -t 1 d/Administer 3ml of example medicine` edits the description of the 1st task of the 1st patient in the patient list to `Administer 3ml of example medicine`, while retaining the original date and time for the task.
* `find Betsy` followed by `edit -p 2 -t 3 d/Change dressing on left arm | 23-10-2022` edits the description of the 3rd task of the 2nd patient in results of the `find` command to `Change dressing on left arm` and also changes the date and time for the task to 23rd October 2022.

### Deleting a task: `delete -p -t`

Deletes the specified task or recurring task associated with a patient.

Format: `delete -p PATIENT_INDEX -t TASK_INDEX`

* Deletes the task at the specified `TASK_INDEX` of the patient at the specified `PATIENT_INDEX`.
* The task index refers to the index number shown in the task list of a patient.
* The patient index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:
* `list` followed by `delete -p 2 -t 3` deletes the 3rd task of the 2nd patient in the patient list.
* `find Betsy` followed by `delete -p 1 -t 2` deletes the 2nd task of the 1st patient in results of the `find` command.

### Listing all tasks: `listTask`

Shows a list of all tasks to be completed.

Format: `listTask`

Examples:

Suppose the following patients were added.

`add n/John Doe d/Administer 3ml of example medicine`

`add n/Betsy Crowe d/Change dressing on left arm`
* `listTask` will display:
    * `Administer 3ml of example medicine FOR John Doe`
    * `Change dressing on left arm FOR Betsy Crowe`

### View all tasks associated with a patient: `viewTask`

Shows all the tasks that are associated with the specified patient.

Format: `viewTask INDEX`

Examples:

Suppose the following patients were added.

`add n/John Doe d/Administer 3ml of example medicine`

`add n/Betsy Crowe d/Change dressing on left arm`
* `viewTask 1` will display:
    * `Administer 3ml of example medicine`
* `viewTask 2` will display:
    * `Change dressing on left arm`

### Adding a medical condition: `addCondition`

_Command syntax to be updated ..._

Format: `addCondition PATIENT_INDEX c/CONDITION`
* Adds a medical condition to a patient at the specified `PATIENT_INDEX`.

Examples:
* `list` followed by `addCondition 1 c/Diabetes` adds a condition to the 1st patient in the patient list.
* `find Betsy` followed by `addCondition 2 c/Alzhiemer's disease` adds a condition to the 2nd patient in the patient list.

### Deleting a medical condition: `deleteCondition`

_Command syntax to be updated ..._

Format: `deleteCondition PATIENT_INDEX CONDITION_INDEX`
* Deletes the medical condition at the specified `CONDITION_INDEX` of the patient at the specified `PATIENT_INDEX`.

Examples:
* `list` followed by `deleteCondition 2 3` deletes the 3rd condition of the 2nd patient in the patient list.
* `find Betsy` followed by `deleteCondition 1 2` deletes the 2nd condition of the 1st patient in the patient list.

### Adding a tag: `addTag`

_Command syntax to be updated ..._

Format: `addTag PATIENT_INDEX t/TAG`
* Adds a tag to a patient at the specified `PATIENT_INDEX`.

Examples:
* `list` followed by `addTag 1 t/highRisk` adds a tag to the 1st patient in the patient list.
* `find Betsy` followed by `addTag 2 t/elderly` adds a tag to the 2nd patient in the patient list.

### Deleting a tag: `deleteTag`

_Command syntax to be updated ..._

Format: `deleteTag PATIENT_INDEX TAG_INDEX`
* Deletes the tag at the specified `TAG_INDEX` of the patient at the specified `PATIENT_INDEX`.

Examples:
* `list` followed by `deleteTag 2 3` deletes the 3rd tag of the 2nd patient in the patient list.
* `find Betsy` followed by `deleteTag 1 2` deletes the 2nd tag of the 1st patient in the patient list.

### Clearing all entries: `clear`

Clears all patient entries in the displayed patient list.

Format: `clear`

Examples:
* `list` followed by `clear` will delete all patients.
* `find Betsy` followed by `clear` deletes all patients in the results of the `find` command.

### Undo last command: `undo`

Undoes the last command which modifies the patient or task list, which includes `add`, `edit`, `delete`, and `clear` commands.

Format: `undo`

Examples:
* `delete -p 2` followed by `undo` has the same effect as not doing the `delete` command.
* `delete -p 2` followed by `list`, then followed by `undo` will undo the `delete` command.

### Reverse undo command: `redo`

Undoes the last `undo` command.

Format: `redo`

Example:
* `undo` followed by `redo` has the same effect as not doing the `undo` command.

### Exiting the program: `exit`

Exits the program.

Format: `exit`

### Saving the data

UniNurse data are saved in the hard disk automatically after any command that changes the data.
There is no need to save manually.

### Editing the data file

UniNurse data are saved as a JSON file `[JAR file location]/data/uninurse.json`.
Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, UniNurse will discard all data and start with an empty
data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous UniNurse home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                          | Format                                                                   |
|---------------------------------|--------------------------------------------------------------------------|
| **Help**                        | `help`                                                                   |
| **Add patient**                 | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [d/TASK]`                   |
| **Edit patient**                | `edit -p INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…` |
| **Delete patient**              | `delete -p INDEX`                                                        |
| **List all patients**           | `list`                                                                   |
| **List all patients today**     | `patientsToday`                                                          |
| **Find patient**                | `find [KEYWORD]… [n/NAME]… [p/PHONE]… [e/EMAIL]… [a/ADDRESS]… [t/TAG]… [c/CONDITION]… [d/TASK_DESCRIPTION]… [m/MEDICATION]…` |
| **Add task**                    | `add -p PATIENT_INDEX d/TASK`                                            |
| **Edit task**                   | `edit -p PATIENT_INDEX -d TASK_INDEX d/TASK`                             |
| **Delete task**                 | `delete -p PATIENT_INDEX -d TASK_INDEX`                                  |
| **List all tasks**              | `listTask`                                                               |
| **View all tasks of a patient** | `viewTask INDEX`                                                         |
| **Add condition**               | `addCondition PATIENT_INDEX c/CONDITION`                                 |
| **Delete condition**            | `deleteCondition PATIENT_INDEX CONDITION_INDEX`                          |
| **Add tag**                     | `addTag INDEX t/TAG`                                                     |
| **Delete tag**                  | `deleteTag PATIENT_INDEX TAG_INDEX`                                |                                                             
| **Clear all patients**          | `clear`                                                                  |
| **Undo last command**           | `undo`                                                                   |
| **Reverse undo command**        | `redo`                                                                   |
| **Exit**                        | `exit`                                                                   |

* Note that `TASK` is composed of `TASK_DESCRIPTION | DATE_AND_TIME | FREQUENCY`
* `DATE_AND_TIME` should be in the format like 16-10-2022 1030
* If no `DATE_AND_TIME` is provided, then a default date and time of 24 hours from creation will be set
* Frequency is an optional tag that is used to specify recurring tasks, the valid values for this field are `daily`, `weekly` and `monthly`. Capitalisation does not matter
* If a frequency is not specified, it's a normal task
* Note that both `DATE_AND_TIME` and `FREQUENCY` are optional fields, however to have a recurring task both of them are required, while you can have a normal task with date time not be recurring, i.e `FREQUENCY` not required
