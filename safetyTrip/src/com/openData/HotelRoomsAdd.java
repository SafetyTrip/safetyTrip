package com.openData;

import java.util.List;

import com.dto.RoomDTO;
import com.exception.MyException;
import com.service.HotelService;
import com.service.RoomService;


public class HotelRoomsAdd {

	public static void main(String[] args) {
		RoomService rService = new RoomService();
		HotelService hService = new HotelService();
		
		try {
			List<Integer> list = hService.hotelSelectList();

			for(int hno: list) {
				RoomDTO dto = new RoomDTO();
				dto.setHno(hno);
				
				for(int i=101;i<600;i++) {
					dto.setNum(i);
					rService.roomInsert(dto);

					if(i%100 == 5) {
						i += 95;
					}
				}
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
