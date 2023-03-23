const all_users = document.getElementById("data-allUser");
const url1 = 'http://localhost:8080/api/admin/users';
let res1 = '';

function showAllUsers() {
    fetch(url1)
        .then( (response) => response.json())
        .then( (users) => {
            users.forEach(user => {
                res1 += `<tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.username}</td>
                    <td>${user.roleList.map(role => " " + role.name.substring(5))}</td>
                    <td><a class="btnEdit btn btn-info">Edit</a></td>
                    <td><a class="btnDelete btn btn-danger">Delete</a></td>
                </tr>`;
            });
            all_users.innerHTML = res1;
        })
        .catch(error => console.log(error));

}
