document.getElementById("fetchJavaData").addEventListener("click", () => {
  fetch("http://localhost:8080/data") // Java backend
    .then((response) => response.json())
    .then((data) => {
      const container = document.getElementById("dataContainer");
      container.innerHTML = ""; // Clear previous data

      data.forEach((item) => {
        const div = document.createElement("div");
        div.className = "data-item";
        div.innerHTML = `
                  <div><strong>ID:</strong> ${item.id}</div>
                  <div><strong>Name:</strong> ${item.name}</div>
                  <div><strong>Email:</strong> ${item.email}</div>
              `;
        container.appendChild(div);
      });
    })
    .catch((error) => console.error("Error fetching data:", error));
});

document.getElementById("fetchScalaData").addEventListener("click", () => {
  fetch("http://localhost:8081/data") // Scala backend
    .then((response) => response.text())
    .then((data) => {
      const container = document.getElementById("dataContainer");
      container.innerHTML = `
              <div class="data-item">${data}</div>
          `;
    })
    .catch((error) => console.error("Error fetching data:", error));
});
