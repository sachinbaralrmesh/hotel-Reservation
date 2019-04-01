package programs;

class Bookingdetails {
	private Integer startDate;
	private Integer endDate;
	private Availability result;

	/**
	 * @param endDate the endDate to set
	 */
	public void setendDate(int endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setstartDate(int startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Integer getendDate() {
		return endDate;
	}

	/**
	 * @return the startDate
	 */
	public Integer getstartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public Availability getResult() {
		return result;
	}

	/**
	 * @return the startDate
	 */
	public void setResult(Availability result) {
		this.result = result;
	}

}