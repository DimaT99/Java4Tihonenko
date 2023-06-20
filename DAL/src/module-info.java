import repository.LectureRepo;

module DAL {
    exports repository;
    requires transitive SERVICE;
    uses repository.LectureRepo;
    provides repository.Repo with LectureRepo;
}