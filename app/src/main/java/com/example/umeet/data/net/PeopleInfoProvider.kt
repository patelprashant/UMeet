package com.example.umeet.data.net

import com.example.umeet.data.model.People

class PeopleInfoProvider {

    companion object {
        var peopleList = initPeopleList()

        /**
         * Initialises peopleList with dummy data
         */
        private fun initPeopleList(): MutableList<People> {
            var peoples = mutableListOf<People>()
            peoples.add(
                People(
                    "Ray Wenderlich",
                    "RW Campus",
                    "228-40332240",
                    "ray@razeware.com",
                    "facebook.com/raywenderlich",
                    1
                )
            )
            peoples.add(
                People(
                    "Mark Tremonti",
                    "Alter Bridge Concert",
                    "228-44012312",
                    "mark@alterbridge.com",
                    "facebook.com/tremonti",
                    2
                )
            )
            peoples.add(
                People(
                    "Jeff Bezos",
                    "Amazon HQ",
                    "206-26622992",
                    "j.bezos@amazon.com",
                    "facebook.com/j.bezos",
                    3
                )
            )
            peoples.add(
                People(
                    "Mark Zuckerberg",
                    "Facebook",
                    "228-41124312",
                    "mark@facebook.com",
                    "facebook.com/mz",
                    4
                )
            )
            peoples.add(
                People(
                    "Bil Gates",
                    "Microsoft HQ",
                    "206-24541837",
                    "gates@microsoft.com",
                    "facebook.com/b.gates",
                    5
                )
            )
            peoples.add(
                People(
                    "Tim Cook",
                    "Apple, Cupertino",
                    "310-27753123",
                    "cook@apple.com",
                    "facebook.com/t.cook",
                    6
                )
            )
            peoples.add(
                People(
                    "Sundar Pichai",
                    "Google CA",
                    "310-46645322",
                    "s.pichai@gmail.com",
                    "facebook.com/s.pichai",
                    7
                )
            )
            peoples.add(
                People(
                    "Elon Musk",
                    "SpaceX Campus",
                    "310-35666875",
                    "musk@spacex.com",
                    "facebook.com/e.musk",
                    8
                )
            )
            return peoples
        }
    }
}
