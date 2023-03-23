const user_page = document.getElementById("data-userpage");
const user_header = document.getElementById("user-header")
const url = 'http://localhost:8080/api/viewUser';
let res = '';

function showUser() {
    fetch(url)
        .then( (response) => response.json())
        .then( (user) => {
            res +=
                `<tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.username}</td>
                <td>${user.roleList.map(role => " " + role.name.substring(5))}</td>
            </tr>`;
           user_page.innerHTML = res;
           user_header.innerHTML = `<h5>${user.username} with roles: ${user.roleList.map(role => " " + role.name.substring(5))}</h5>`

        });
}
showUser();
