package com.wab.clima.model.pojos;

import org.springframework.data.domain.Page;

public class ResponsePageablePojo<T> {

	private ResponsePageInfo pageInfo;
	private T data;

	public ResponsePageablePojo(T data, Page<?> page) {
		this.data = data;
		this.pageInfo = new ResponsePageInfo(page.getTotalPages(), page.getNumber(), page.getTotalElements(), page.getNumberOfElements(), page.getSize());
	}

	public ResponsePageInfo getPageInfo() {
		return pageInfo;
	}

	public T getData() {
		return data;
	}

	public static class ResponsePageInfo {

		private int totalPages;
		private int pageNumber;
		private long totalElements;
		private int numberOfElements;
		private int limit;

		public ResponsePageInfo(int totalPages, int pageNumber, long totalElements, int numberOfElements, int limit) {
			this.totalPages = totalPages;
			this.pageNumber = pageNumber + 1;
			this.totalElements = totalElements;
			this.numberOfElements = numberOfElements;
			this.limit = limit;
		}

		public int getTotalPages() {
			return totalPages;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public long getTotalElements() {
			return totalElements;
		}

		public int getNumberOfElements() {
			return numberOfElements;
		}

		public int getLimit() {
			return limit;
		}
	}
}
