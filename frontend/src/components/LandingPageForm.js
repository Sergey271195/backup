import React, { useState, useEffect } from "react";

const LandingPageForm = () => {
  const [skills, setSkills] = useState();
  const [chosenSkill, setChosenSkill] = useState(1);
  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [date, setDate] = useState("");



  useEffect(() => {
    fetch("/api/landing/skills")
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setSkills(data);
      });
  }, []);

  const postApplication = () => {
      fetch("/api/landing/application", {
          method: "POST",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({name, email, phone, skill_id: chosenSkill, date})
      })
      .then(response => response.json())
      .then(data => console.log(data))

  }

  const handleSubmit = (event) => {
      event.preventDefault();
      console.log(chosenSkill);
      console.log(name);
      console.log(email);
      console.log(phone);
      console.log(date);
      console.log(JSON.stringify({name, email, phone, skill_id: chosenSkill, date}))
      postApplication();
  }

  return (
    <form style={{ display: "flex", flexDirection: "column", alignItems: "center"}} onSubmit = {handleSubmit}>
      <input type="text" value = {name} required placeholder="Имя" onChange = {event => setName(event.target.value)}/>
      <input type="text" value = {email} required placeholder="Email" onChange = {event => setEmail(event.target.value)}/>
      <input type="text" value = {phone} required placeholder="Телефон" onChange = {event => setPhone(event.target.value)}/>
      <input type="datetime" required value = {date}  onChange = {event => setDate(event.target.value)}/>
      <h3>Специализация</h3>
      <div style = {{display: "flex", flexDirection: "column"}}>
        {skills &&
          skills.map((skill) => {
            return (
              <label>
                <input
                  type="radio"
                  name="skill"
                  value={skill.id}
                  onChange={(event) => setChosenSkill(event.target.value)}
                  checked={chosenSkill == skill.id}
                />
                {skill.name}
              </label>
            );
          })}
      </div>
      <button type = "submit">Записаться на собеседование</button>
    </form>
  );
};

export default LandingPageForm;
