function openModal(id) {
    fetch(`/data/character/${id}`)
    .then(response => response.json())
    .then(data => {
        document.getElementById('modalTitle').innerText = data.name;
        document.getElementById('modalImage').src = data.image;
        document.getElementById('modalStatus').innerText = data.status;
        document.getElementById('modalSpecies').innerText = data.species;
        document.getElementById('modalType').innerText = data.type;
        document.getElementById('modalGender').innerText = data.gender;
        $('#characterModal').modal('show');
    });
}