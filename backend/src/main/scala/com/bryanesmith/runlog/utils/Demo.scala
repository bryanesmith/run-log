package com.bryanesmith.runlog.utils

import com.bryanesmith.runlog.dto.Events._
import com.bryanesmith.runlog.dto.Intervals._
import com.bryanesmith.runlog.dto.SteadyState._

object Demo {

  def events = Seq(
    Event(
      atId = "_:338",
      atType = Type.RunCrossTrain,
      date = "2019-10-05",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 6,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(9.0),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("1.98mi + lift")
    ),
    Event(
      atId = "_:337",
      atType = Type.Run,
      date = "2019-10-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.14)
        )
      )
    ),
    Event(
      atId = "_:336",
      atType = Type.Run,
      date = "2019-09-29",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.93)
        )
      ),
      notes = Some("Few small breaks; hard due to yesterday's workout and few weeks since last long run.")
    ),
    Event(
      atId = "_:335",
      atType = Type.RunCrossTrain,
      date = "2019-09-28",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 6,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.9),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("1.96mi + lift")
    ),
    Event(
      atId = "_:334",
      atType = Type.RunCrossTrain,
      date = "2019-09-21",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 6,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.8),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("1.96mi + lift")
    ),
    Event(
      atId = "_:333",
      atType = Type.Run,
      date = "2019-09-19",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.69)
        )
      )
    ),
    Event(
      atId = "_:332",
      atType = Type.CrossTrain,
      date = "2019-09-18"
    ),
    Event(
      atId = "_:331",
      atType = Type.Run,
      date = "2019-09-15",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.5)
        )
      )
    ),
    Event(
      atId = "_:330",
      atType = Type.RunCrossTrain,
      date = "2019-09-14",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 6,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.7),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("1.95mi + lift")
    ),
    Event(
      atId = "_:329",
      atType = Type.Run,
      date = "2019-09-12",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.14)
        )
      )
    ),
    Event(
      atId = "_:328",
      atType = Type.CrossTrain,
      date = "2019-09-11"
    ),
    Event(
      atId = "_:327",
      atType = Type.Run,
      date = "2019-09-07",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.53)
        )
      )
    ),
    Event(
      atId = "_:326",
      atType = Type.CrossTrain,
      date = "2019-09-03"
    ),
    Event(
      atId = "_:325",
      atType = Type.Run,
      date = "2019-09-01",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.25)
        )
      )
    ),
    Event(
      atId = "_:324",
      atType = Type.RunCrossTrain,
      date = "2019-08-31",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 6,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.6),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("1.94mi + lift")
    ),
    Event(
      atId = "_:323",
      atType = Type.CrossTrain,
      date = "2019-08-27"
    ),
    Event(
      atId = "_:322",
      atType = Type.Run,
      date = "2019-08-25",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.94)
        )
      )
    ),
    Event(
      atId = "_:321",
      atType = Type.CrossTrain,
      date = "2019-08-20"
    ),
    Event(
      atId = "_:320",
      atType = Type.Run,
      date = "2019-08-18",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14)
        )
      ),
      notes = Some("Short walking break halfway through, tired from yesterday's training.")
    ),
    Event(
      atId = "_:319",
      atType = Type.RunCrossTrain,
      date = "2019-08-17",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 6,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.5),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("1.91 mi HIIT, bench press, incline press, skull crusher, cable tricep extension.")
    ),
    Event(
      atId = "_:318",
      atType = Type.CrossTrain,
      date = "2019-08-15"
    ),
    Event(
      atId = "_:317",
      atType = Type.CrossTrain,
      date = "2019-08-12"
    ),
    Event(
      atId = "_:316",
      atType = Type.Run,
      date = "2019-08-11",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14)
        )
      )
    ),
    Event(
      atId = "_:315",
      atType = Type.CrossTrain,
      date = "2019-08-07"
    ),
    Event(
      atId = "_:314",
      atType = Type.Run,
      date = "2019-08-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14)
        )
      )
    ),
    Event(
      atId = "_:313",
      atType = Type.CrossTrain,
      date = "2019-08-03"
    ),
    Event(
      atId = "_:312",
      atType = Type.CrossTrain,
      date = "2019-07-31"
    ),
    Event(
      atId = "_:311",
      atType = Type.CrossTrain,
      date = "2019-07-27"
    ),
    Event(
      atId = "_:310",
      atType = Type.CrossTrain,
      date = "2019-07-25"
    ),
    Event(
      atId = "_:309",
      atType = Type.CrossTrain,
      date = "2019-07-19"
    ),
    Event(
      atId = "_:308",
      atType = Type.CrossTrain,
      date = "2019-07-17"
    ),
    Event(
      atId = "_:307",
      atType = Type.Run,
      date = "2019-07-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14)
        )
      )
    ),
    Event(
      atId = "_:306",
      atType = Type.CrossTrain,
      date = "2019-07-13"
    ),
    Event(
      atId = "_:305",
      atType = Type.CrossTrain,
      date = "2019-07-10"
    ),
    Event(
      atId = "_:304",
      atType = Type.CrossTrain,
      date = "2019-07-08"
    ),
    Event(
      atId = "_:303",
      atType = Type.CrossTrain,
      date = "2019-07-06"
    ),
    Event(
      atId = "_:302",
      atType = Type.CrossTrain,
      date = "2019-07-03"
    ),
    Event(
      atId = "_:301",
      atType = Type.CrossTrain,
      date = "2019-07-01"
    ),
    Event(
      atId = "_:300",
      atType = Type.CrossTrain,
      date = "2019-06-29"
    ),
    Event(
      atId = "_:299",
      atType = Type.CrossTrain,
      date = "2019-06-28"
    ),
    Event(
      atId = "_:298",
      atType = Type.CrossTrain,
      date = "2019-06-26"
    ),
    Event(
      atId = "_:297",
      atType = Type.CrossTrain,
      date = "2019-06-25"
    ),
    Event(
      atId = "_:296",
      atType = Type.CrossTrain,
      date = "2019-06-21"
    ),
    Event(
      atId = "_:295",
      atType = Type.CrossTrain,
      date = "2019-06-20"
    ),
    Event(
      atId = "_:294",
      atType = Type.CrossTrain,
      date = "2019-06-15"
    ),
    Event(
      atId = "_:293",
      atType = Type.CrossTrain,
      date = "2019-06-14"
    ),
    Event(
      atId = "_:292",
      atType = Type.CrossTrain,
      date = "2019-06-12"
    ),
    Event(
      atId = "_:291",
      atType = Type.CrossTrain,
      date = "2019-06-11"
    ),
    Event(
      atId = "_:290",
      atType = Type.CrossTrain,
      date = "2019-06-08"
    ),
    Event(
      atId = "_:289",
      atType = Type.CrossTrain,
      date = "2019-06-07"
    ),
    Event(
      atId = "_:288",
      atType = Type.CrossTrain,
      date = "2019-06-04"
    ),
    Event(
      atId = "_:287",
      atType = Type.CrossTrain,
      date = "2019-06-03"
    ),
    Event(
      atId = "_:286",
      atType = Type.CrossTrain,
      date = "2019-06-01"
    ),
    Event(
      atId = "_:285",
      atType = Type.CrossTrain,
      date = "2019-05-29"
    ),
    Event(
      atId = "_:284",
      atType = Type.CrossTrain,
      date = "2019-05-24"
    ),
    Event(
      atId = "_:283",
      atType = Type.CrossTrain,
      date = "2019-05-22"
    ),
    Event(
      atId = "_:282",
      atType = Type.CrossTrain,
      date = "2019-05-20",
      notes = Some("Bench, squat, decline/incline pushups, skull crushers, cable tricep extensions, standing tricep extensions")
    ),
    Event(
      atId = "_:281",
      atType = Type.CrossTrain,
      date = "2019-05-18",
      notes = Some("Press, DL, DB row, alternating/preacher curls, front/lateral raises")
    ),
    Event(
      atId = "_:280",
      atType = Type.CrossTrain,
      date = "2019-05-17",
      notes = Some("Bench, squat, decline/incline pushups, skull crushers, cable tricep extensions, standing tricep extensions")
    ),
    Event(
      atId = "_:279",
      atType = Type.CrossTrain,
      date = "2019-05-11",
      notes = Some("DB bench press, DB squat. DB DL, DB skull crushers, cable tricep extensions.")
    ),
    Event(
      atId = "_:278",
      atType = Type.CrossTrain,
      date = "2019-05-04",
      notes = Some("DB bench press, DB squat. DB DL, DB skull crushers, cable tricep extensions.")
    ),
    Event(
      atId = "_:277",
      atType = Type.CrossTrain,
      date = "2019-04-27",
      notes = Some("DB bench press, DB DL, DB press, DB skull crushers, cable tricep extensions.")
    ),
    Event(
      atId = "_:276",
      atType = Type.Run,
      date = "2019-04-21",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.02)
        )
      )
    ),
    Event(
      atId = "_:275",
      atType = Type.RunCrossTrain,
      date = "2019-04-20",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.6),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.45 mi HIIT, bench press, squat, DB row.")
    ),
    Event(
      atId = "_:274",
      atType = Type.Run,
      date = "2019-04-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.56)
        )
      )
    ),
    Event(
      atId = "_:273",
      atType = Type.RunCrossTrain,
      date = "2019-04-13",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.5),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("~2.44 mi HIIT, press, squat, DB row.")
    ),
    Event(
      atId = "_:272",
      atType = Type.Run,
      date = "2019-04-09",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.05)
        )
      ),
      notes = Some("East Falls Church to Foggy Bottom")
    ),
    Event(
      atId = "_:271",
      atType = Type.Run,
      date = "2019-04-07",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.56),
          duration = Some("PT1H13M50S")
        )
      )
    ),
    Event(
      atId = "_:270",
      atType = Type.ChangeShoes,
      date = "2019-04-07",
      notes = Some("Also wore shoes once before during marathon")
    ),
    Event(
      atId = "_:269",
      atType = Type.CrossTrain,
      date = "2019-04-04",
      notes = Some("Bench, squat, DL")
    ),
    Event(
      atId = "_:268",
      atType = Type.Run,
      date = "2019-04-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.75)
        )
      ),
      notes = Some("McLean to Foggy Bottom")
    ),
    Event(
      atId = "_:268",
      atType = Type.CrossTrain,
      date = "2018-03-28",
      notes = Some("Press, squat, DL")
    ),
    Event(
      atId = "_:267",
      atType = Type.Run,
      date = "2019-03-27",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(7.68)
        )
      ),
      notes = Some("Running has somehow gotten harder.")
    ),
    Event(
      atId = "_:266",
      atType = Type.Run,
      date = "2019-03-24",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(7.68)
        )
      ),
      notes = Some("Getting over cold.")
    ),
    Event(
      atId = "_:265",
      atType = Type.CrossTrain,
      date = "2018-03-23",
      notes = Some("Bench, squat, DL")
    ),
    Event(
      atId = "_:264",
      atType = Type.Run,
      date = "2019-03-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.02)
        )
      ),
      notes = Some("Calves still sore from marathon.")
    ),
    Event(
      atId = "_:263",
      atType = Type.Run,
      date = "2019-03-09",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(26.2),
          duration = Some("PT4H22M10S")
        )
      ),
      notes = Some("My first marathon! Rock n' Roll DC.")
    ),
    Event(
      atId = "_:263",
      atType = Type.Run,
      date = "2019-03-05",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(7.7)
        )
      ),
      notes = Some("Last normal run before my first marathon!")
    ),
    Event(
      atId = "_:262",
      atType = Type.Run,
      date = "2019-03-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(7.7)
        )
      )
    ),
    Event(
      atId = "_:261",
      atType = Type.Run,
      date = "2019-03-02",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(11.06)
        )
      )
    ),
    Event(
      atId = "_:260",
      atType = Type.Run,
      date = "2019-02-28",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(3.55)
        )
      )
    ),
    Event(
      atId = "_:259",
      atType = Type.Run,
      date = "2019-02-24",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(15.42),
          duration = Some("PT2H26M44S")
        )
      )
    ),
    Event(
      atId = "_:258",
      atType = Type.Run,
      date = "2019-02-22",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.98)
        )
      )
    ),
    Event(
      atId = "_:257",
      atType = Type.Run,
      date = "2019-02-19",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14)
        )
      )
    ),
    Event(
      atId = "_:256",
      atType = Type.Run,
      date = "2019-02-17",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(23.5),
          duration = Some("PT3H54M51S")
        )
      ),
      notes = Some("Bonked around 70% in. Ran-walked last quintile, which was +25.7% duration of first quintile.")
    ),
    Event(
      atId = "_:255",
      atType = Type.Run,
      date = "2019-02-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.98)
        )
      )
    ),
    Event(
      atId = "_:254",
      atType = Type.Run,
      date = "2019-02-13",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(12.11)
        )
      )
    ),
    Event(
      atId = "_:253",
      atType = Type.Run,
      date = "2019-02-09",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(14.49)
        )
      )
    ),
    Event(
      atId = "_:252",
      atType = Type.Run,
      date = "2019-02-07",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.15)
        )
      )
    ),
    Event(
      atId = "_:251",
      atType = Type.Run,
      date = "2019-02-06",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.56)
        )
      )
    ),
    Event(
      atId = "_:250",
      atType = Type.Run,
      date = "2019-02-05",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.21)
        )
      )
    ),
    Event(
      atId = "_:249",
      atType = Type.Run,
      date = "2019-02-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.56)
        )
      )
    ),
    Event(
      atId = "_:248",
      atType = Type.Run,
      date = "2019-02-02",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(22.56),
          duration = Some("PT3H38M49S")
        )
      )
    ),
    Event(
      atId = "_:247",
      atType = Type.Run,
      date = "2019-01-28",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.11)
        )
      )
    ),
    Event(
      atId = "_:246",
      atType = Type.Run,
      date = "2019-01-27",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(20.56),
          duration = Some("PT3H09M11S")
        )
      )
    ),
    Event(
      atId = "_:245",
      atType = Type.Run,
      date = "2019-01-25",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(12.58)
        )
      )
    ),
    Event(
      atId = "_:244",
      atType = Type.Run,
      date = "2019-01-23",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(11.52)
        )
      )
    ),
    Event(
      atId = "_:243",
      atType = Type.Run,
      date = "2019-01-19",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(19.4),
          duration = Some("PT2H58M35S")
        )
      )
    ),
    Event(
      atId = "_:242",
      atType = Type.Run,
      date = "2019-01-17",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(9.0),
          duration = Some("PT1H21M2S")
        )
      )
    ),
    Event(
      atId = "_:241",
      atType = Type.RunCrossTrain,
      date = "2019-01-15",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(9.3),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("~2.54 mi HIIT, bench, squat, DB row.")
    ),
    Event(
      atId = "_:240",
      atType = Type.Run,
      date = "2019-01-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.0)
        )
      )
    ),
    Event(
      atId = "_:239",
      atType = Type.Run,
      date = "2019-01-12",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(18.0),
          duration = Some("PT2H28M50S")
        )
      )
    ),
    Event(
      atId = "_:238",
      atType = Type.Run,
      date = "2019-01-10",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.98)
        )
      )
    ),
    Event(
      atId = "_:237",
      atType = Type.Run,
      date = "2019-01-08",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.98)
        )
      )
    ),
    Event(
      atId = "_:236",
      atType = Type.Run,
      date = "2019-01-05",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.5)
        )
      )
    ),
    Event(
      atId = "_:235",
      atType = Type.Run,
      date = "2019-01-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:234",
      atType = Type.Run,
      date = "2019-01-01",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(15.5)
        )
      )
    ),
    Event(
      atId = "_:233",
      atType = Type.CrossTrain,
      date = "2018-12-30",
      notes = Some("Bench, squat, DL, bent over row")
    ),
    Event(
      atId = "_:232",
      atType = Type.RunCrossTrain,
      date = "2018-12-28",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(9.2),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.5ish mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:231",
      atType = Type.Run,
      date = "2018-12-26",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(17.0)
        )
      )
    ),
    Event(
      atId = "_:230",
      atType = Type.Run,
      date = "2018-12-24",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.56)
        )
      )
    ),
    Event(
      atId = "_:229",
      atType = Type.Run,
      date = "2018-12-22",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(16.51)
        )
      )
    ),
    Event(
      atId = "_:228",
      atType = Type.Run,
      date = "2018-12-20",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.79)
        )
      )
    ),
    Event(
      atId = "_:227",
      atType = Type.Run,
      date = "2018-12-18",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.05)
        )
      )
    ),
    Event(
      atId = "_:226",
      atType = Type.RunCrossTrain,
      date = "2018-12-17",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(9.1),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.62mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:225",
      atType = Type.RunCrossTrain,
      date = "2018-12-15",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(9.0),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.85mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:224",
      atType = Type.RunCrossTrain,
      date = "2018-12-12",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.8),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.77mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:223",
      atType = Type.Run,
      date = "2018-12-08",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(18.10)
        )
      )
    ),
    Event(
      atId = "_:222",
      atType = Type.Run,
      date = "2018-12-06",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:221",
      atType = Type.Run,
      date = "2018-12-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:220",
      atType = Type.ChangeShoes,
      date = "2018-12-04"
    ),
    Event(
      atId = "_:219",
      atType = Type.Run,
      date = "2018-12-01",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(17.2)
        )
      )
    ),
    Event(
      atId = "_:218",
      atType = Type.Run,
      date = "2018-11-29",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:217",
      atType = Type.Run,
      date = "2018-11-26",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:216",
      atType = Type.Run,
      date = "2018-11-25",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6)
        )
      )
    ),
    Event(
      atId = "_:215",
      atType = Type.Run,
      date = "2018-11-22",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(15.2)
        )
      )
    ),
    Event(
      atId = "_:214",
      atType = Type.RunCrossTrain,
      date = "2018-11-20",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.7),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.75mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:213",
      atType = Type.Run,
      date = "2018-11-19",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:212",
      atType = Type.RunCrossTrain,
      date = "2018-11-17",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.6),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.7mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:211",
      atType = Type.Run,
      date = "2018-11-16",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.05)
        )
      )
    ),
    Event(
      atId = "_:210",
      atType = Type.Run,
      date = "2018-11-13",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(15.74)
        )
      )
    ),
    Event(
      atId = "_:209",
      atType = Type.Run,
      date = "2018-11-11",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.56)
        )
      )
    ),
    Event(
      atId = "_:208",
      atType = Type.RunCrossTrain,
      date = "2018-11-10",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(8.5),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("2.68mi HIIT, bench, squat, DL.")
    ),
    Event(
      atId = "_:207",
      atType = Type.Run,
      date = "2018-11-08",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(10.98)
        )
      )
    ),
    Event(
      atId = "_:206",
      atType = Type.Run,
      date = "2018-11-06",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.05)
        )
      )
    ),
    Event(
      atId = "_:205",
      atType = Type.Run,
      date = "2018-11-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.05)
        )
      )
    ),
    Event(
      atId = "_:204",
      atType = Type.Run,
      date = "2018-11-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.56),
          duration = Some("PT49M22S")
        )
      )
    ),
    Event(
      atId = "_:203",
      atType = Type.Run,
      date = "2018-10-30",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(10.8)
        )
      )
    ),
    Event(
      atId = "_:202",
      atType = Type.Run,
      date = "2018-10-28",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.72),
          duration = Some("PT40M23S")
        )
      )
    ),
    Event(
      atId = "_:201",
      atType = Type.Run,
      date = "2018-10-25",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.5)
        )
      ),
      notes = Some("McLean to Foggy Bottom.")
    ),
    Event(
      atId = "_:200",
      atType = Type.Run,
      date = "2018-10-23",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(10.8)
        )
      ),
      notes = Some("First time East Falls Church to home.")
    ),
    Event(
      atId = "_:199",
      atType = Type.Run,
      date = "2018-10-21",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.66)
        )
      ),
      notes = Some("18+ mi in around 18hrs. Really sore.")
    ),
    Event(
      atId = "_:198",
      atType = Type.Run,
      date = "2018-10-20",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.65)
        )
      )
    ),
    Event(
      atId = "_:197",
      atType = Type.Run,
      date = "2018-10-16",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(6.6)
        )
      ),
      notes = Some("Attempted to run from McLean to DC. Worst run ever.")
    ),
    Event(
      atId = "_:196",
      atType = Type.CrossTrain,
      date = "2018-10-15",
      notes = Some("Press, bench, squat, DL")
    ),
    Event(
      atId = "_:195",
      atType = Type.Run,
      date = "2018-10-09",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.06),
          duration = Some("PT1H52M38S")
        )
      )
    ),
    Event(
      atId = "_:194",
      atType = Type.Run,
      date = "2018-10-07",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.5)
        )
      ),
      notes = Some("Flushing NYC")
    ),
    Event(
      atId = "_:193",
      atType = Type.Run,
      date = "2018-10-06",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.5)
        )
      ),
      notes = Some("Flushing NYC")
    ),
    Event(
      atId = "_:192",
      atType = Type.Run,
      date = "2018-10-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(10.02),
          duration = Some("PT1H36M20S")
        )
      )
    ),
    Event(
      atId = "_:191",
      atType = Type.Run,
      date = "2018-10-01",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.72)
        )
      )
    ),
    Event(
      atId = "_:190",
      atType = Type.Run,
      date = "2018-09-30",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(9.1),
          duration = Some("PT1H29M22S")
        )
      )
    ),
    Event(
      atId = "_:189",
      atType = Type.Run,
      date = "2018-09-28",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.56)
        )
      )
    ),
    Event(
      atId = "_:188",
      atType = Type.RunCrossTrain,
      date = "2018-09-27",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(3.0),
          duration = Some("PT27M15S")
        )
      )
    ),
    Event(
      atId = "_:187",
      atType = Type.Run,
      date = "2018-09-25",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT43M")
        )
      )
    ),
    Event(
      atId = "_:186",
      atType = Type.Run,
      date = "2018-09-23",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.2),
          duration = None
        )
      ),
      notes = Some("Ashland, KY")
    ),
    Event(
      atId = "_:185",
      atType = Type.Run,
      date = "2018-09-22",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.3),
          duration = None
        )
      ),
      notes = Some("Ashland, KY")
    ),
    Event(
      atId = "_:184",
      atType = Type.Run,
      date = "2018-09-21",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.3),
          duration = Some("PT44M46S")
        )
      )
    ),
    Event(
      atId = "_:183",
      atType = Type.CrossTrain,
      date = "2018-09-19",
      notes = Some("Press, Bench, Squat")
    ),
    Event(
      atId = "_:182",
      atType = Type.Run,
      date = "2018-09-18",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.63),
          duration = Some("PT58M05S")
        )
      )
    ),
    Event(
      atId = "_:181",
      atType = Type.Run,
      date = "2018-09-16",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.2),
          duration = Some("PT1H26M50S")
        )
      ),
      notes = Some("Tired from yesterday's race.")
    ),
    Event(
      atId = "_:180",
      atType = Type.Run,
      date = "2018-09-15",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Speed,
          distance = Some(3.11),
          duration = Some("PT25M58S")
        )
      ),
      notes = Some("Race to Beat Cancer 5K")
    ),
    Event(
      atId = "_:n179",
      atType = Type.CrossTrain,
      date = "2018-09-04",
      notes = Some("Press, bent-over row, DL, standing tricep extension.")
    ),
    Event(
      atId = "_:178",
      atType = Type.Run,
      date = "2018-09-02",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.05),
          duration = Some("PT1H24M38S")
        )
      )
    ),
    Event(
      atId = "_:177",
      atType = Type.Run,
      date = "2018-08-30",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.05),
          duration = Some("PT1H21M30S")
        )
      )
    ),
    Event(
      atId = "_:n176",
      atType = Type.CrossTrain,
      date = "2018-08-28",
      notes = Some("Bench, squats, dips + incline PU, DB pullover, some arm stuff.")
    ),
    Event(
      atId = "_:175",
      atType = Type.Run,
      date = "2018-08-26",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT42M38S")
        )
      ),
      notes = Some("3rd day running in a row, so tired. Very hard.")
    ),
    Event(
      atId = "_:174",
      atType = Type.Run,
      date = "2018-08-25",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Speed,
          distance = Some(2.77),
          duration = Some("PT23M3S")
        )
      ),
    ),
    Event(
      atId = "_:173",
      atType = Type.Run,
      date = "2018-08-24",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.41),
          duration = Some("PT1H12M12S")
        )
      ),
    ),
    Event(
      atId = "_:n172",
      atType = Type.CrossTrain,
      date = "2018-08-23",
      notes = Some("Press, bent-over row, DL, standing tricep extension.")
    ),
    Event(
      atId = "_:171",
      atType = Type.RunCrossTrain,
      date = "2018-08-20",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.0),
          duration = Some("PT36M16S")
        )
      ),
      notes = Some("Bench, squats, dips + incline PU, DB pullover.")
    ),
    Event(
      atId = "_:170",
      atType = Type.Run,
      date = "2018-08-19",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.0),
          duration = Some("PT36M23S")
        )
      ),
    ),
    Event(
      atId = "_:169",
      atType = Type.Run,
      date = "2018-08-17",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.0),
          duration = Some("PT36M02S")
        )
      ),
    ),
    Event(
      atId = "_:n168",
      atType = Type.CrossTrain,
      date = "2018-08-15",
      notes = Some("Press, bent-over row, DL, standing tricep extension.")
    ),
    Event(
      atId = "_:167",
      atType = Type.RunCrossTrain,
      date = "2018-08-13",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.0),
          duration = Some("PT36M16S")
        )
      ),
      notes = Some("Bench, Dips + Incline PU, DB pullover")
    ),
    Event(
      atId = "_:166",
      atType = Type.Run,
      date = "2018-08-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(2.0),
          duration = Some("PT16M54S")
        )
      )
    ),
    Event(
      atId = "_:165",
      atType = Type.Run,
      date = "2018-08-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.16),
          duration = Some("PT1H33S")
        )
      )
    ),
    Event(
      atId = "_:n164",
      atType = Type.CrossTrain,
      date = "2018-07-31",
      notes = Some("Press, squat, bent-over row, standing tricep extension, curl supersets, cable tricep extension.")
    ),
    Event(
      atId = "_:163",
      atType = Type.Run,
      date = "2018-07-29",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(7.06),
          duration = Some("PT1H11M54S")
        )
      )
    ),
    Event(
      atId = "_:n162",
      atType = Type.CrossTrain,
      date = "2018-07-28",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:161",
      atType = Type.Run,
      date = "2018-07-26",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.03),
          duration = Some("PT1H19M36S")
        )
      )
    ),
    Event(
      atId = "_:n160",
      atType = Type.CrossTrain,
      date = "2018-07-25",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:159",
      atType = Type.Run,
      date = "2018-07-22",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(8.03),
          duration = Some("PT1H20M")
        )
      ),
      notes = Some("Morning run, still sore from running last night.")
    ),
    Event(
      atId = "_:n158",
      atType = Type.CrossTrain,
      date = "2018-07-18",
      notes = Some("Bench, squat, dips + incline PUs.")
    ),
    Event(
      atId = "_:157",
      atType = Type.Run,
      date = "2018-07-17",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.15)
        )
      ),
      notes = Some("Mission district, San Francisco.")
    ),
    Event(
      atId = "_:156",
      atType = Type.Run,
      date = "2018-07-15",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT44M21S")
        )
      ),
      notes = Some("Morning run, still sore from running last night.")
    ),
    Event(
      atId = "_:155",
      atType = Type.Run,
      date = "2018-07-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT42M50S")
        )
      )
    ),
    Event(
      atId = "_:n154",
      atType = Type.CrossTrain,
      date = "2018-07-12",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n153",
      atType = Type.CrossTrain,
      date = "2018-07-10",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:152",
      atType = Type.Run,
      date = "2018-07-09",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT42M50S")
        )
      )
    ),
    Event(
      atId = "_:151",
      atType = Type.Run,
      date = "2018-07-08",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.98),
          duration = Some("PT1H8S")
        )
      )
    ),
    Event(
      atId = "_:n150",
      atType = Type.CrossTrain,
      date = "2018-07-05",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:149",
      atType = Type.Run,
      date = "2018-07-04",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT42M44S")
        )
      )
    ),
    Event(
      atId = "_:n148",
      atType = Type.CrossTrain,
      date = "2018-07-02",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:147",
      atType = Type.Run,
      date = "2018-07-01",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT44M")
        )
      )
    ),
    Event(
      atId = "_:n146",
      atType = Type.CrossTrain,
      date = "2018-06-28",
      notes = Some("Press, rows, DL.")
    ),
    Event(
      atId = "_:n145",
      atType = Type.CrossTrain,
      date = "2018-06-26",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n144",
      atType = Type.CrossTrain,
      date = "2018-06-21",
      notes = Some("Press, rows, DL.")
    ),
    Event(
      atId = "_:143",
      atType = Type.Run,
      date = "2018-06-17",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT42M1S")
        )
      )
    ),
    Event(
      atId = "_:n142",
      atType = Type.CrossTrain,
      date = "2018-06-16",
      notes = Some("Standing biceps cable curl, triceps pushdown, v-bar pulldown, incline db curl/seated db curl superset, close-grip bench press, seated triceps press, db alternate bicep curl.")
    ),
    Event(
      atId = "_:n141",
      atType = Type.CrossTrain,
      date = "2018-06-14",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n140",
      atType = Type.CrossTrain,
      date = "2018-06-12",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n139",
      atType = Type.CrossTrain,
      date = "2018-06-07",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n138",
      atType = Type.CrossTrain,
      date = "2018-06-05",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n137",
      atType = Type.CrossTrain,
      date = "2018-06-02",
      notes = Some("Bench, squat, DB pull-overs, dips + incline PUs.")
    ),
    Event(
      atId = "_:n136",
      atType = Type.CrossTrain,
      date = "2018-05-29",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n135",
      atType = Type.CrossTrain,
      date = "2018-05-26",
      notes = Some("Standing biceps cable curl, triceps pushdown, v-bar pulldown, incline db curl/seated db curl superset, close-grip bench press, seated triceps press, db alternate bicep curl, farmer's walk.")
    ),
    Event(
      atId = "_:n134",
      atType = Type.CrossTrain,
      date = "2018-05-24",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n133",
      atType = Type.CrossTrain,
      date = "2018-05-22",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n132",
      atType = Type.CrossTrain,
      date = "2018-05-19",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n131",
      atType = Type.CrossTrain,
      date = "2018-05-15",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n130",
      atType = Type.CrossTrain,
      date = "2018-05-12",
      notes = Some("Bench, squat, turning compost.")
    ),
    Event(
      atId = "_:n129",
      atType = Type.CrossTrain,
      date = "2018-05-05",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n128",
      atType = Type.Run,
      date = "2018-05-03",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.98)
        )
      )
    ),
    Event(
      atId = "_:n127",
      atType = Type.CrossTrain,
      date = "2018-05-02",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n126",
      atType = Type.Run,
      date = "2018-04-30",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.57),
          duration = Some("PT55M37S")
        )
      )
    ),
    Event(
      atId = "_:n125",
      atType = Type.CrossTrain,
      date = "2018-04-28",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n124",
      atType = Type.CrossTrain,
      date = "2018-04-26",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n123",
      atType = Type.CrossTrain,
      date = "2018-04-23",
      notes = Some("Circuit training.")
    ),
    Event(
      atId = "_:n122",
      atType = Type.Run,
      date = "2018-04-18",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.37),
          duration = Some("PT50M50S")
        )
      )
    ),
    Event(
      atId = "_:n121",
      atType = Type.CrossTrain,
      date = "2018-04-17",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n120",
      atType = Type.CrossTrain,
      date = "2018-04-10",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n119",
      atType = Type.CrossTrain,
      date = "2018-04-02",
      notes = Some("Circuit training.")
    ),
    Event(
      atId = "_:n118",
      atType = Type.CrossTrain,
      date = "2018-03-31",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n117",
      atType = Type.CrossTrain,
      date = "2018-03-27",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n116",
      atType = Type.Run,
      date = "2018-03-18",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.63),
          duration = Some("PT50M46S")
        )
      )
    ),
    Event(
      atId = "_:n115",
      atType = Type.ChangeShoes,
      date = "2018-03-18",
      notes = Some("Third pair of Nike Zoom")
    ),
    Event(
      atId = "_:n114",
      atType = Type.Run,
      date = "2018-03-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.07),
          duration = Some("PT55M10S")
        )
      )
    ),
    Event(
      atId = "_:n113",
      atType = Type.CrossTrain,
      date = "2018-03-12",
      notes = Some("Circuit training.")
    ),
    Event(
      atId = "_:n112",
      atType = Type.CrossTrain,
      date = "2018-03-10",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n111",
      atType = Type.CrossTrain,
      date = "2018-03-06",
      notes = Some("Bench, squat, dips + incline PUs, DB pull-overs.")
    ),
    Event(
      atId = "_:n110",
      atType = Type.CrossTrain,
      date = "2018-03-05",
      notes = Some("Circuit training.")
    ),
    Event(
      atId = "_:n109",
      atType = Type.Run,
      date = "2018-02-27",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.70),
          duration = Some("PT45M12S")
        )
      ),
      notes = Some("Scottsdale, Dessert Botanic Garden. Hilly.")
    ),
    Event(
      atId = "_:n108",
      atType = Type.CrossTrain,
      date = "2018-02-26",
      notes = Some("Scottsdale, hotel gym. Dips, vertical chess press, front lat pull, curls.")
    ),
    Event(
      atId = "_:n107",
      atType = Type.CrossTrain,
      date = "2018-02-24",
      notes = Some("Press, rows, DL, standing tricep extensions.")
    ),
    Event(
      atId = "_:n106",
      atType = Type.Run,
      date = "2018-02-23",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 3,
          intervalDuration = Some("PT1M38S"),
          intervalSpeed = Some(10.0),
        )
      ),
      notes = Some("Tired from last two days exercise.")
    ),
    Event(
      atId = "_:n105",
      atType = Type.CrossTrain,
      date = "2018-02-22",
      notes = Some("Bench, squat, wall squat, dips/incline PU, DB pull-overs.")
    ),
    Event(
      atId = "_:n104",
      atType = Type.Run,
      date = "2018-02-21",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(6.07),
          duration = Some("PT56M35S")
        )
      )
    ),
    Event(
      atId = "_:n103",
      atType = Type.Run,
      date = "2018-02-19",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Speed,
          distance = Some(3.10),
          duration = Some("PT24M07S")
        )
      ),
      notes = Some("Outdoor 5k.")
    ),
    Event(
      atId = "_:n102",
      atType = Type.Run,
      date = "2018-02-17",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(10.1),
          restDuration = Some("PT1M")
        )
      )
    ),
    Event(
      atId = "_:n101",
      atType = Type.CrossTrain,
      date = "2018-02-15",
      notes = Some("Press, bench, squat, rows.")
    ),
    Event(
      atId = "_:n100",
      atType = Type.Run,
      date = "2018-02-14",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.77),
          duration = Some("PT1H09M46S")
        )
      )
    ),
    Event(
      atId = "_:n99",
      atType = Type.Run,
      date = "2018-02-12",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Speed,
          distance = Some(3.16),
          duration = Some("PT24M47S")
        )
      ),
      notes = Some("Outdoor 5k.")
    ),
    Event(
      atId = "_:n98",
      atType = Type.Run,
      date = "2018-02-10",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 8,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(10.0),
          restDuration = Some("PT1M")
        )
      )
    ),
    Event(
      atId = "_:n97",
      atType = Type.CrossTrain,
      date = "2018-02-08",
      notes = Some("Press, bent-over row, DL, DB pull-over.")
    ),
    Event(
      atId = "_:n96",
      atType = Type.Run,
      date = "2018-02-07",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Casual,
          distance = Some(2.70),
          duration = Some("PT24M40S")
        )
      ),
      notes = Some("Tight calves, stopped early.")
    ),
    Event(
      atId = "_:n95",
      atType = Type.Run,
      date = "2018-02-06",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Speed,
          distance = Some(3.11),
          duration = Some("PT24M27S")
        )
      ),
      notes = Some("Outdoor 5k. Tired from yesterday, started too strong.")
    ),
    Event(
      atId = "_:n94",
      atType = Type.RunCrossTrain,
      date = "2018-02-05",
      runData = Some(
        SteadyStateRun(
          category = SteadyStateRunCategory.Speed,
          distance = Some(2.25),
          duration = Some("PT16M27S")
        )
      ),
      notes = Some("Attempting 22min 3mi, but couldn't finish. Followed by circuit training.")
    ),
    Event(
      atId = "_:n93",
      atType = Type.RunCrossTrain,
      date = "2018-02-03",
      runData = Some(
        Intervals(
          category = IntervalsCategory.Intervals,
          count = 7,
          intervalDuration = Some("PT1M"),
          intervalSpeed = Some(10.0),
          restDuration = Some("PT1M")
        )
      ),
      notes = Some("First intervals. Just fell short of eight. Bench, squat, invisible chair, dips/incline PU.")
    ),
    Event(
      atId = "_:n92",
      atType = Type.Run,
      date = "2018-01-31",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.55),
          duration = Some("PT42M13S")
        )
      ),
    ),
    Event(
      atId = "_:n91",
      atType = Type.RunCrossTrain,
      date = "2018-01-30",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(0.55),
          duration = Some("PT3M18S"),
        )
      ),
      notes = Some("Attempting first 6min mile, but unsuccessful. Press, bent-over row, DL, DB pull-over.")
    ),
    Event(
      atId = "_:n90",
      atType = Type.CrossTrain,
      date = "2018-01-27",
      notes = Some("Bench, squat, invisible chair, dips/incline PU, standing tricep extensions, farmer's walk.")
    ),
    Event(
      atId = "_:n89",
      atType = Type.Run,
      date = "2018-01-26",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT36M16S")
        )
      )
    ),
    Event(
      atId = "_:n88",
      atType = Type.CrossTrain,
      date = "2018-01-25",
      notes = Some("Press, bent-over row, DL, DB pull-over, farmer's walk.")
    ),
    Event(
      atId = "_:n87",
      atType = Type.RunCrossTrain,
      date = "2018-01-22",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(0.6),
          duration = Some("PT3M45S"),
        )
      ),
      notes = Some("9.6mph + circuit training. Couldn't finish the mile.")
    ),
    Event(
      atId = "_:n86",
      atType = Type.Run,
      date = "2018-01-21",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.07),
          duration = Some("PT34M54S")
        )
      )
    ),
    Event(
      atId = "_:n85",
      atType = Type.Run,
      date = "2018-01-20",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M18S"),
        )
      ),
      notes = Some("Warmed up in under 5 min!"),
      favorite = Some(true)
    ),
    Event(
      atId = "_:n84",
      atType = Type.CrossTrain,
      date = "2018-01-18",
      notes = Some("Bench, squat, invisible chair, dips/incline PU, standing tricep extensions.")
    ),
    Event(
      atId = "_:n83",
      atType = Type.CrossTrain,
      date = "2018-01-16",
      notes = Some("Press, row, DL, farmer's walk.")
    ),
    Event(
      atId = "_:n82",
      atType = Type.Run,
      date = "2018-01-15",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.72),
          duration = Some("PT41M17S")
        )
      )
    ),
    Event(
      atId = "_:n81",
      atType = Type.CrossTrain,
      date = "2018-01-13",
      notes = Some("Bench, squat, invisible chair, dips/incline PUs, db tricep ext.")
    ),
    Event(
      atId = "_:n80",
      atType = Type.Run,
      date = "2018-01-12",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.55),
          duration = Some("PT41M33S"),
        )
      ),
      notes = Some("January, and weather in the sixties!")
    ),
    Event(
      atId = "_:n79",
      atType = Type.Run,
      date = "2018-01-10",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.55),
          duration = Some("PT43M40S")
        )
      )
    ),
    Event(
      atId = "_:n78",
      atType = Type.CrossTrain,
      date = "2018-01-09",
      notes = Some("Press, row, DL")
    ),
    Event(
      atId = "_:n77",
      atType = Type.RunCrossTrain,
      date = "2018-01-08",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M22S"),
        )
      ),
      notes = Some("And resumed circuit training.")
    ),
    Event(
      atId = "_:n76",
      atType = Type.CrossTrain,
      date = "2018-01-06",
      notes = Some("Bench, squat, invisible chair, dips/incline PUs, tricep ext, farmer's walk.")
    ),
    Event(
      atId = "_:n75",
      atType = Type.Run,
      date = "2018-01-04",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(0.75),
          duration = Some("PT4M47S"),
        )
      ),
      notes = Some("Couldn't finish mile; need rest day prior to speed run.")
    ),
    Event(
      atId = "_:n74",
      atType = Type.Run,
      date = "2018-01-03",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(2.68),
          duration = Some("PT24M40S"),
        )
      ),
      notes = Some("Run home, cold, but too tired. Took streetcar home.")
    ),
    Event(
      atId = "_:n73",
      atType = Type.CrossTrain,
      date = "2018-01-02",
      notes = Some("Press, rows, DL, farmer's walk")
    ),
    Event(
      atId = "_:n72",
      atType = Type.Run,
      date = "2018-01-01",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.98),
          duration = Some("PT53M59S")
        )
      )
    ),
    Event(
      atId = "_:n71",
      atType = Type.CrossTrain,
      date = "2017-12-30",
      notes = Some("Bench, Squat, Press, Dips, Farmer's Walk, Incline Pushups/Invisible Chair."),
    ),
    Event(
      atId = "_:n70",
      atType = Type.RunCrossTrain,
      date = "2017-12-28",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(2),
          duration = Some("PT16M"),
        )
      ),
      notes = Some("Ashland, KY. Treadmill, 1° incline. Congested from cold, but feeling better."),
    ),
    Event(
      atId = "_:n69",
      atType = Type.RunCrossTrain,
      date = "2017-12-27",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(1.5),
          duration = Some("PT11M15S"),
        )
      ),
      notes = Some("Ashland, KY. Treadmill, 1° incline. Sick w/ cold."),
    ),
    Event(
      atId = "_:n68",
      atType = Type.Run,
      date = "2017-12-25",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.40),
        )
      ),
      notes = Some("Christmas run with Matt, David, dad.")
    ),
    Event(
      atId = "_:n67",
      atType = Type.Run,
      date = "2017-12-24",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.55),
          duration = Some("PT1H14M45S"),
        )
      )
    ),
    Event(
      atId = "_:n66",
      atType = Type.CrossTrain,
      date = "2017-12-21"
    ),
    Event(
      atId = "_:n65",
      atType = Type.RunCrossTrain,
      date = "2017-12-19",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M27S"),
        )
      ),
      notes = Some("My first 6:30 mile."),
    ),
    Event(
      atId = "_:n64",
      atType = Type.Run,
      date = "2017-12-18",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.07),
          duration = Some("PT34M22S"),
        )
      )
    ),
    Event(
      atId = "_:n63",
      atType = Type.RunCrossTrain,
      date = "2017-12-16",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(3.00),
          duration = Some("PT22M47S"),
        )
      ),
      favorite = Some(true),
      notes = Some("Three-mile run to kick off workout."),
    ),
    Event(
      atId = "_:n62",
      atType = Type.Run,
      date = "2017-12-11",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.77),
          duration = Some("PT1H11M54S"),
        )
      )
    ),
    Event(
      atId = "_:n61",
      atType = Type.RunCrossTrain,
      date = "2017-12-09",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(0.68),
          duration = Some("PT4M23S"),
        )
      )
    ),
    Event(
      atId = "_:n60",
      atType = Type.RunCrossTrain,
      date = "2017-12-07",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(3),
          duration = Some("PT23M3S"),
        )
      )
    ),
    Event(
      atId = "_:n59",
      atType = Type.Run,
      date = "2017-12-06",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.77),
          duration = Some("PT1H13M35S"),
        )
      )
    ),
    Event(
      atId = "_:n58",
      atType = Type.RunCrossTrain,
      date = "2017-12-02",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M31S"),
        )
      )
    ),
    Event(
      atId = "_:n57",
      atType = Type.RunCrossTrain,
      date = "2017-11-30",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(3),
          duration = Some("PT23M23S"),
        )
      )
    ),
    Event(
      atId = "_:n56",
      atType = Type.Run,
      date = "2017-11-29",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.8),
          duration = Some("PT44M53S"),
        )
      )
    ),
    Event(
      atId = "_:n55",
      atType = Type.Run,
      date = "2017-11-27",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.48),
          duration = Some("PT43M00S"),
        )
      )
    ),
    Event(
      atId = "_:n54",
      atType = Type.Run,
      date = "2017-11-26",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.21),
          duration = Some("PT36M56S"),
        )
      )
    ),
    Event(
      atId = "_:n53",
      atType = Type.RunCrossTrain,
      date = "2017-11-25",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M35S"),
        )
      )
    ),
    Event(
      atId = "_:n52",
      atType = Type.RunCrossTrain,
      date = "2017-11-22",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(3),
          duration = Some("PT23M41S"),
        )
      )
    ),
    Event(
      atId = "_:n51",
      atType = Type.Run,
      date = "2017-11-20",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(12.21),
          duration = Some("PT1H55M"),
        )
      ),
      notes = Some("Doesn't include short walk & stretch break."),
      favorite = Some(true),
    ),
    Event(
      atId = "_:n50",
      atType = Type.RunCrossTrain,
      date = "2017-11-18",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(3),
          duration = Some("PT24M"),
        )
      )
    ),
    Event(
      atId = "_:n49",
      atType = Type.RunCrossTrain,
      date = "2017-11-16",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M40S"),
        )
      )
    ),
    Event(
      atId = "_:n48",
      atType = Type.Run,
      date = "2017-11-13",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.58),
          duration = Some("PT40M50S"),
        )
      )
    ),
    Event(
      atId = "_:n47",
      atType = Type.Run,
      date = "2017-11-11",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(2),
          duration = Some("PT17M08S"),
        )
      )
    ),
    Event(
      atId = "_:n46",
      atType = Type.RunCrossTrain,
      date = "2017-11-09",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(0.6),
          duration = Some("PT4M"),
        )
      )
    ),
    Event(
      atId = "_:n45",
      atType = Type.Run,
      date = "2017-11-07",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(3.99),
          duration = Some("PT37M40S"),
        )
      )
    ),
    Event(
      atId = "_:n44",
      atType = Type.Run,
      date = "2017-11-06",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.65),
          duration = Some("PT46M30S"),
        )
      )
    ),
    Event(
      atId = "_:n43",
      atType = Type.Run,
      date = "2017-11-03",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.65),
          duration = Some("PT1H15M"),
        )
      )
    ),
    Event(
      atId = "_:n42",
      atType = Type.Run,
      date = "2017-11-01",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.04),
          duration = Some("PT55M15S"),
        )
      )
    ),
    Event(
      atId = "_:n41",
      atType = Type.Run,
      date = "2017-10-30",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.04),
          duration = Some("PT54M15S"),
        )
      )
    ),
    Event(
      atId = "_:n40",
      atType = Type.RunCrossTrain,
      date = "2017-10-28",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M44S"),
        )
      )
    ),
    Event(
      atId = "_:n39",
      atType = Type.Run,
      date = "2017-10-25",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.77),
          duration = Some("PT1H20M"),
        )
      )
    ),
    Event(
      atId = "_:n38",
      atType = Type.Run,
      date = "2017-10-22",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.52),
          duration = Some("PT1H52M30S"),
        )
      )
    ),
    Event(
      atId = "_:n37",
      atType = Type.RunCrossTrain,
      date = "2017-10-21",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M49S"),
        )
      )
    ),
    Event(
      atId = "_:n36",
      atType = Type.Run,
      date = "2017-10-18",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.37),
          duration = Some("PT1H19M20S"),
        )
      ),
      notes = Some("commute, running pack"),
    ),
    Event(
      atId = "_:n35",
      atType = Type.Run,
      date = "2017-10-15",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.56),
          duration = Some("PT1H23M"),
        )
      )
    ),
    Event(
      atId = "_:n34",
      atType = Type.RunCrossTrain,
      date = "2017-10-14",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(2),
          duration = Some("PT16M"),
        )
      )
    ),
    Event(
      atId = "_:n33",
      atType = Type.CrossTrain,
      date = "2017-10-11"
    ),
    Event(
      atId = "_:n32",
      atType = Type.Run,
      date = "2017-10-08",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.70),
          duration = Some("PT1H24M09S"),
        )
      )
    ),
    Event(
      atId = "_:n31",
      atType = Type.CrossTrain,
      date = "2017-10-07"
    ),
    Event(
      atId = "_:n30",
      atType = Type.RunCrossTrain,
      date = "2017-10-05",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(1),
          duration = Some("PT8M"),
        )
      )
    ),
    Event(
      atId = "_:n29",
      atType = Type.Run,
      date = "2017-10-04",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.41),
          duration = Some("PT53M44S"),
        )
      )
    ),
    Event(
      atId = "_:n28",
      atType = Type.RunCrossTrain,
      date = "2017-10-02",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(2),
          duration = Some("PT17M22S"),
        )
      )
    ),
    Event(
      atId = "_:n27",
      atType = Type.Run,
      date = "2017-10-01",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.33),
          duration = Some("PT1H09M20S"),
        )
      )
    ),
    Event(
      atId = "_:n25",
      atType = Type.RunCrossTrain,
      date = "2017-09-30",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(3),
          duration = Some("PT25M21S"),
        )
      )
    ),
    Event(
      atId = "_:n24",
      atType = Type.Run,
      date = "2017-09-24",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(7.71),
          duration = Some("PT1H14M30S"),
        )
      )
    ),
    Event(
      atId = "_:n23",
      atType = Type.RunCrossTrain,
      date = "2017-09-23",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(2),
          duration = Some("PT16M"),
        )
      )
    ),
    Event(
      atId = "_:n21",
      atType = Type.RunCrossTrain,
      date = "2017-09-21",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT6M58S"),
        )
      )
    ),
    Event(
      atId = "_:n19",
      atType = Type.Run,
      date = "2017-09-20",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.43),
          duration = Some("PT49M40S"),
        )
      )
    ),
    Event(
      atId = "_:n18",
      atType = Type.Run,
      date = "2017-09-17",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(11.01),
          duration = Some("PT1H56M"),
        )
      )
    ),
    Event(
      atId = "_:n17",
      atType = Type.Run,
      date = "2017-09-15",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(6.02),
          duration = Some("PT60M"),
        )
      )
    ),
    Event(
      atId = "_:n16",
      atType = Type.CrossTrain,
      date = "2017-09-14",
      notes = Some("Lift: db press, bench, dl"),
    ),
    Event(
      atId = "_:n15",
      atType = Type.Run,
      date = "2017-09-13",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.52),
          duration = Some("PT53M30S"),
        )
      )
    ),
    Event(
      atId = "_:n14",
      atType = Type.CrossTrain,
      date = "2017-09-11",
      notes = Some("Circuit training: 2 sets"),
    ),
    Event(
      atId = "_:n13",
      atType = Type.Run,
      date = "2017-09-10",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(10.45),
          duration = Some("PT1H46M"),
        )
      )
    ),
    Event(
      atId = "_:n12",
      atType = Type.CrossTrain,
      date = "2017-09-09",
      notes = Some("Lift: db press, squat, bench, dl"),
    ),
    Event(
      atId = "_:n11",
      atType = Type.Run,
      date = "2017-09-03",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(9.01),
          duration = Some("PT1H30M50S"),
        )
      )
    ),
    Event(
      atId = "_:n10",
      atType = Type.Run,
      date = "2017-09-02",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT7M13S"),
        )
      ),
      notes = Some("Treadmill, 1° incline, 8.3mph"),
    ),
    Event(
      atId = "_:n9",
      atType = Type.Run,
      date = "2017-08-30",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.64),
          duration = Some("PT45M44S"),
        )
      ),
      notes = Some("Burdened: running bag w/ 15MBP. From office to home."),
    ),
    Event(
      atId = "_:n7",
      atType = Type.RunCrossTrain,
      date = "2017-08-28",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Speed,
          distance = Some(1),
          duration = Some("PT7M24S"),
        )
      ),
      notes = Some("Treadmill, 1° incline; 2 sets circuit training"),
    ),
    Event(
      atId = "_:n6",
      atType = Type.Run,
      date = "2017-08-27",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Distance,
          distance = Some(8.56),
          duration = Some("PT1H22M30S"),
        )
      ),
      notes = Some("All four quadrants DC"),
    ),
    Event(
      atId = "_:n5",
      atType = Type.Run,
      date = "2017-08-24",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT40M35S"),
        )
      ),
      notes = Some("C St to Union Station to H St."),
    ),
    Event(
      atId = "_:n4",
      atType = Type.Run,
      date = "2017-08-22",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.14),
          duration = Some("PT40M50S"),
        )
      ),
      notes = Some("C St to Union Station to H St."),
    ),
    Event(
      atId = "_:n3",
      atType = Type.Run,
      date = "2017-08-18",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(5.23),
          duration = Some("PT51M30S"),
        )
      ),
      notes = Some("Ann Arbor: Stadium to TJ to Washtenaw to South U."),
    ),
    Event(
      atId = "_:n2",
      atType = Type.Run,
      date = "2017-08-16",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(2.67),
        )
      )
    ),
    Event(
      atId = "_:n1",
      atType = Type.Run,
      date = "2017-08-15",
      runData = Some(
        SteadyStateRun (
          category = SteadyStateRunCategory.Casual,
          distance = Some(4.39),
        )
      ),
      notes = Some("Ann Arbor: Main to Stadium to mall."),
    )
  )
}
