import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import SortingMethodsDropdown from "./SortingMethodsDropdown";
import http from "../utils/http-service";
import StudentTable from "./StudentTable";
import SelectStudentsFile from "./SelectStudentsFile";
import ErrorMessage from "./ErrorMessage";
import Button from "./SortButton";

function StudentSorter() {
  const [unsortedStudents, setUnsortedStudents] = useState();
  const [students, setStudents] = useState();
  const [studentCount, setStudentCount] = useState();
  const [sortingTime, setSortingTime] = useState();
  const [selectedMethod, setSelectedMethod] = useState();
  const [sortingMethods, setSortingMethods] = useState();
  const [errorMessage, setErrorMessage] = useState();

  useEffect(() => {
    async function fetchSortingTypes() {
      http.get("/students/sort").then((response) => {
        setSortingMethods(response.data);
      });
    }
    fetchSortingTypes();
  }, []);

  async function sortStudents() {
    setErrorMessage();
    setSortingTime();
    setStudentCount();
    setStudents(unsortedStudents);
    if (students && selectedMethod) {
      http
        .post("/students/sort", {
          sortingMethod: selectedMethod,
          students: students,
        })
        .then((response) => {
          setStudents(response?.data?.students);
          setStudentCount(response?.data?.studentCount);
          setSortingTime(response?.data?.sortingTime);
        })
        .catch((error) => {
          setErrorMessage(error.response.data);
        });
    } else {
      setErrorMessage("No file or sorting method selected.");
    }
  }

  return (
    <div>
      <div className="px-6">
        <SelectStudentsFile setStudents={setStudents} setUnsortedStudents={setUnsortedStudents}/>
        <div className="flex">
          <SortingMethodsDropdown
            options={sortingMethods}
            setState={setSelectedMethod}
          />
          <span className="my-5 mx-2">
            <Button label="Sort" onClick={sortStudents} />
          </span>
        </div>

        {studentCount && <div>{`Student count: ${studentCount}`}</div>}
        {sortingTime && <div>{`Time spent sorting: ${sortingTime}`}</div>}
        {errorMessage && <ErrorMessage message={errorMessage} />}
      </div>

      {students && <StudentTable students={students} />}
    </div>
  );
}

export default StudentSorter;
