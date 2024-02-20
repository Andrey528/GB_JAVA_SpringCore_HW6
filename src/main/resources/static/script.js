function openModal(id) {
    fetch(`/data/character/${id}?page=${new URLSearchParams(window.location.search).get('page')}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Character not found');
        }
        return response.json();
    })
    .then(data => {
        document.getElementById('modalTitle').innerText = data.name;
        document.getElementById('modalImage').src = data.image;
        document.getElementById('modalStatus').innerText = data.status;
        document.getElementById('modalSpecies').innerText = data.species;
        document.getElementById('modalType').innerText = data.type;
        document.getElementById('modalGender').innerText = data.gender;
        $('#characterModal').modal('show');
    })
    .catch(error => {
        alert(error.message);
    });
}